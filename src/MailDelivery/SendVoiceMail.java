package MailDelivery;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class SendVoiceMail {
	private static String requestUrl = "https://bgl-cxn-st-3.cisco.com:8443/vmrest/messages?userobjectid=9d7f24aa-8e59-4d67-9e43-7dd55d90040e";
	File file1 = null;
	File file2 = null;
	File voiceMessage = null;
	ResponseEntity<String> entity = null;

	public static void main(String[] args) throws Exception {
		SendVoiceMail sendVoiceMail = new SendVoiceMail();
		sendVoiceMail.sendMail();

	}

	void sendMail() throws IOException {
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory(true));
		restTemplate.setErrorHandler(new ErrorResponseHandler());

		String userPassword = "Abhijeet:Ecsbulab1";
		String basicAuth = Base64.getEncoder().encodeToString(userPassword.getBytes());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " +basicAuth);
		
		String subject = "Voicemail from Prashant Prashant (ext - 1037)"; 
		String message = String.format("{\"Subject\" : \"%s\", \"Sensitivity\" : \"Normal\", \"Priority\" : \"Normal\" }", subject);

		// creating an HttpEntity for the message part
		HttpHeaders messageHeader = new HttpHeaders();
		messageHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> messageHttpEntity = new HttpEntity<>(message, messageHeader);

		String calleeObjectId = "8ccfcf71-0c07-4dfc-b1c4-00933ba72d13";
		String recipient = String.format("{\"Recipient\" : { \"Type\": \"TO\", \"Address\" : { \"Type\": \"SUBSCRIBER\", \"ObjectId\" : \"%s\"} } }", 
		calleeObjectId);

		// creating an HttpEntity for the recipient part
		HttpHeaders recipientHeader = new HttpHeaders();
		recipientHeader.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> recipientHttpEntity = new HttpEntity<>(recipient, recipientHeader);

		// creating an HttpEntity for the binary part
		HttpHeaders audioHeader = new HttpHeaders();
		audioHeader.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		InputStream audioStream = new FileInputStream("C:/Users/abhibane/Desktop/cumi/AvAfterMsgMenu001.wav");
		ByteArrayResource byteArrayResource = new ByteArrayResource(IOUtils.toByteArray(audioStream));
		HttpEntity<ByteArrayResource> audioHttpEntity = new HttpEntity<>(byteArrayResource, audioHeader);
		//audioStream.close();


		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("message", messageHttpEntity);
		map.add("recipient", recipientHttpEntity);
		map.add("VoiceMessage.wav", audioHttpEntity);

		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
		map, headers);
		System.out.println(requestEntity.getBody());
		System.out.println(requestEntity.getHeaders());
		/*LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("filename", voiceMessage);
		map.add("ArrivalTime", 0);
		map.add("fromSub", false);
		map.add("fromVmIntSub", false);
		map.add("ctr", file1);
		map.add("ctr1", file2);

		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				map, headers);
		System.out.println(requestEntity);
*/		entity = restTemplate.exchange(requestUrl, HttpMethod.POST, requestEntity, String.class);
		System.out.println(entity.getStatusCode());
			}

	/**
	 * method to create http client factory
	 * 
	 * @param isSSLEnabled
	 *            indicates whether ssl should be enabled or not
	 * @throws RestClientException
	 *             in case http client could not be created
	 */
	private ClientHttpRequestFactory getClientHttpRequestFactory(final boolean isSSLEnabled) {

		try {
			return new HttpComponentsClientHttpRequestFactory(HttpClientUtils.createHttpClient(isSSLEnabled));
		} catch (

		Exception ex) {
			throw new RestClientException("ssl initialization failed", ex);
		}
	}
}
