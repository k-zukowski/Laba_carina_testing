package api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.laba.testing.api.GetPhotoMethods;
import org.testng.annotations.Test;


public class PhotosTest implements IAbstractTest {

  @Test()
  public void getPhotos() {
    GetPhotoMethods getUsersMethods = new GetPhotoMethods();
    getUsersMethods.addParameter("query", "warsaw");
    getUsersMethods.addParameter("page", "1");
    getUsersMethods.addParameter("per_page", "1");
    getUsersMethods.callAPIExpectSuccess();
    getUsersMethods.validateResponseAgainstSchema("api/photos/_getPhotos/rs.schema");
  }

  @Test()
  public void getPhotosError() {
    GetPhotoMethods getUsersMethods = new GetPhotoMethods();
    getUsersMethods.callAPI();
    getUsersMethods.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
    getUsersMethods.validateResponseAgainstSchema("api/photos/_getPhotos/rs_err.schema");
  }
}
