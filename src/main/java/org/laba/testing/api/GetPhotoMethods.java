package org.laba.testing.api;

import static com.zebrunner.carina.utils.Configuration.getEnvArg;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;


@Endpoint(url = "${base_url}/search/photos/", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetPhotoMethods extends AbstractApiMethodV2 {

  public GetPhotoMethods() {
    replaceUrlPlaceholder("base_url", getEnvArg("api_url"));
    this.addUrlParameter("client_id", getEnvArg("api_key"));
  }
}
