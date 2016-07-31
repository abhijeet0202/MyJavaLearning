package MailDelivery;

import java.io.File;
import java.util.Base64;

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
	private static String requestUrl = "https://ucbu-aricent-vm88.cisco.com:8443/vmrest/messages";
	File file1 = null;
	File file2 = null;
	File voiceMessage = null;
	ResponseEntity<String> entity = null;

	public static void main(String[] args) throws Exception {
		SendVoiceMail sendVoiceMail = new SendVoiceMail();
		sendVoiceMail.sendMail();

	}

	void sendMail() {
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory(true));
		restTemplate.setErrorHandler(new ErrorResponseHandler());

		file1 = new File("C:/Users/abhibane/Desktop/cumi/message.xml");
		System.out.println(file1.length());
		file2 = new File("C:/Users/abhibane/Desktop/cumi/recipient.xml");
		System.out.println(file2.length());
		voiceMessage = new File("C:/Users/abhibane/Desktop/cumi/VoiceMessage.wav");
		System.out.println(voiceMessage.exists());

		String userPassword = "admin:ecsbulab";
		String basicAuth = Base64.getEncoder().encodeToString(userPassword.getBytes());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.add(HttpHeaders.AUTHORIZATION, basicAuth);

		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		map.add("filename", voiceMessage);
		map.add("ArrivalTime", 0);
		map.add("fromSub", false);
		map.add("fromVmIntSub", false);
		map.add("ctr", file1);
		map.add("ctr1", file2);

		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
				map, headers);
		System.out.println(requestEntity);
		entity = restTemplate.exchange(requestUrl, HttpMethod.POST, requestEntity, String.class);

		// MultipartPostMethod mPost = new MultipartPostMethod(url);

		// mPost.setRequestHeader ("Authorization", "Basic " + encoding);
		// mPost.setRequestHeader("Content-Type","multipart/form-data");
		// mPost.addPart(new FilePart("ctr", file1, "text/xml","ISO-8859-1"));
		// mPost.addPart(new FilePart("ctr", file2, "text/xml","ISO-8859-1"));
		// mPost.addPart(new FilePart("ctr1", file3, "audio/wav","ISO-8859-1"));
		// mPost.addPart(new FilePart("ctr2", file4, "audio/wav","ISO-8859-1"));
		// mPost.addPart(new FilePart("ctr2", file5, "audio/wav","ISO-8859-1"));
		// client.executeMethod( mPost );
		// String response1 = mPost.getResponseBodyAsString();
		// System.out.println( response1 );
		// System.out.println("------------------------------------------");
		// }
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
