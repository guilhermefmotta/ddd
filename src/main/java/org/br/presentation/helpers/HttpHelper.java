package org.br.presentation.helpers;
import org.br.presentation.errors.ServerError;
import org.br.presentation.protocols.HttpResponse;

public interface HttpHelper<T> {

    static <T> HttpResponse <T> badRequest(String body) {
       HttpResponse<T> httpResponse = new HttpResponse<>();
       httpResponse.setStatusCode(400);
       httpResponse.setBodyString(body);
       return httpResponse;

   }

   static <T> HttpResponse <T> serverError() {
      HttpResponse<T> httpResponse = new HttpResponse<>();
      httpResponse.setStatusCode(500);
      httpResponse.setBodyString(new ServerError().getMessage());
      return httpResponse;
   }

   static <T> HttpResponse <T> ok(T body) {
      HttpResponse<T> httpResponse = new HttpResponse<>();
      httpResponse.setStatusCode(200);
      httpResponse.setBody(body);
      return httpResponse;
   }
}
