package api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.laba.testing.api.GetCollectionMethods;
import org.laba.testing.api.GetCollectionPhotosMethods;
import org.laba.testing.api.GetCollectionsMethods;
import org.testng.annotations.Test;


public class CollectionTest implements IAbstractTest {

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

  @Test()
  public void getCollections() {
    GetCollectionsMethods getCollectionsMethods = new GetCollectionsMethods();
    getCollectionsMethods.addParameter("query", "warsaw");
    getCollectionsMethods.addParameter("page", "1");
    getCollectionsMethods.addParameter("per_page", "1");
    getCollectionsMethods.callAPIExpectSuccess();
    getCollectionsMethods.validateResponseAgainstSchema(
        "api/collection/_getCollections/rs.schema");
  }

  @Test()
  public void getCollectionsError() {
    GetCollectionsMethods getCollectionsMethods = new GetCollectionsMethods();
    getCollectionsMethods.callAPI();
    getCollectionsMethods.expectResponseStatus(HttpResponseStatusType.BAD_REQUEST_400);
    getCollectionsMethods.validateResponseAgainstSchema(
        "api/collection/_getCollections/rs_err.schema");
  }

  @Test()
  public void getCollectionPhotos() {
    GetCollectionPhotosMethods getCollectionPhotosMethods = new GetCollectionPhotosMethods("H84zbzCRww4");
    getCollectionPhotosMethods.callAPIExpectSuccess();
    getCollectionPhotosMethods.validateResponseAgainstSchema(
        "api/collection/_getCollectionPhotos/rs.schema");
  }

  @Test()
  public void getCollectionPhotosError() {
    GetCollectionPhotosMethods getCollectionPhotosMethods = new GetCollectionPhotosMethods("786xz8c875vzx78");
    getCollectionPhotosMethods.callAPI();
    getCollectionPhotosMethods.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
    getCollectionPhotosMethods.validateResponseAgainstSchema(
        "api/collection/_getCollectionPhotos/rs_err.schema");
  }
}
