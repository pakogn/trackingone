package vial.spyc.trackingone;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.guava.reflect.TypeToken;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.Gson;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.spyc.trackingone.data.network.ApiEndPoint;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    /*
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        String  jsonString= "{\"carrier\":{\"address\":null,\"user\":null,\"id\":3,\"name\":\"Transportista3\",\"rfc\":null,\"address_id\":null,\"user_id\":null,\"created_at\":\"2020-01-01T20:48:39.097\",\"updated_at\":null,\"deleted_at\":null,\"formatted_created_at\":\"2020-01-0120:48:39\",\"formatted_updated_at\":\"\",\"formatted_deleted_at\":\"\"},\"user\":{\"contact\":{\"address\":{\"id\":11,\"zipcode\":66634,\"street\":\"MIGUELALEMÁN\",\"ext_number\":0,\"int_number\":0,\"neighborhood\":\"NA\",\"latitud\":25.76669,\"longitude\":-100.191473,\"state\":\"NuevoLeón\",\"country\":null,\"city\":\"CiudadApodaca\"},\"email\":{\"id\":4,\"email_address\":\"lesly.leal@gmail.com\"},\"id\":7,\"email_id\":4,\"address_id\":11},\"id\":7,\"name\":\"MTY02\",\"first_last_name\":\"NA\",\"second_last_name\":\"NA\",\"username\":\"MTY02\",\"password\":\"eyJpdiI6Inp2UkM3T2Jqb0l2cGhrdWRNYVBoZXc9PSIsInZhbHVlIjoicXZqTnlpMjVxVEk3bjNJQ2ZFUG5QUT09IiwibWFjIjoiODhkNWZiYzljMzMwNjJkOGFiMWRjYWI1MTk4NjgwOTkzMmE4YWM0ZWZhNmQ4NTY4Yzc4YTFjMWQzZTE4MzdkMyJ9\",\"auth\":2,\"status\":true,\"contact_id\":7,\"company_id\":null},\"id\":3,\"first_name\":\"Don\",\"last_name\":\"Ramon\",\"carrier_id\":3,\"social_security_number\":\"92919084433\",\"driver_license_number\":\"001000002102\",\"user_id\":7,\"created_at\":\"2020-01-02T00:28:41.607\",\"updated_at\":null,\"deleted_at\":null,\"formatted_created_at\":\"2020-01-0200:28:41\",\"formatted_updated_at\":\"\",\"formatted_deleted_at\":\"\"}";

        Gson gson = new Gson();
        FilaEmbarqueResponse.Driver object = gson.fromJson(jsonString, FilaEmbarqueResponse.Driver.class);

        Assert.assertTrue(object !=null);
    }*/


}
