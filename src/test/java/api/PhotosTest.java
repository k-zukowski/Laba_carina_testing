package api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.laba.testing.api.GetCollectionMethods;
import org.testng.annotations.Test;


public class PhotosTest implements IAbstractTest {

  @Test()
  public void getCollection() {
    GetCollectionMethods getCollectionMethods = new GetCollectionMethods();
    getCollectionMethods.addParameter("id", "H84zbzCRww4");
    getCollectionMethods.callAPIExpectSuccess();
    getCollectionMethods.validateResponseAgainstSchema(
        "api/collection/_getCollection/rs.schema");
  }

  @Test()
  public void getCollectionError() {
    GetCollectionMethods getCollectionMethods = new GetCollectionMethods();
    getCollectionMethods.callAPI();
    getCollectionMethods.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
    getCollectionMethods.validateResponseAgainstSchema(
        "api/collection/_getCollection/rs_err.schema");
  }
}
