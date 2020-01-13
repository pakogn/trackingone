package vial.spyc.trackingone;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.spyc.trackingone.data.network.ApiEndPoint;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Test2() throws Exception {

        String path="D:\\data.json";
        String content;

        content = new String(Files.readAllBytes(Paths.get(path)));
        String jsonString= content;
        // JSONArray inputArray = new JSONArray(jsonString);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<FilaEmbarqueResponse>>() {}.getType();
        List<FilaEmbarqueResponse> object = gson.fromJson(jsonString, listType);

        Assert.assertTrue(object !=null);
    }

    @Test
    public void Test2Fail() throws Exception {

        String path="D:\\data2.json";
        String content;

        content = new String(Files.readAllBytes(Paths.get(path)));
        String jsonString= content;
        // JSONArray inputArray = new JSONArray(jsonString);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<FilaEmbarqueResponse>>() {}.getType();
        List<FilaEmbarqueResponse> object = gson.fromJson(jsonString, listType);

        Assert.assertTrue(object !=null);
    }
    @Test
    public void testObject() throws Exception {

        String path="D:\\data3.json";
        String content;

        content = new String(Files.readAllBytes(Paths.get(path)));
        String jsonString= content;
        // JSONArray inputArray = new JSONArray(jsonString);
        Gson gson = new Gson();

       FilaEmbarqueResponse object = gson.fromJson(jsonString, FilaEmbarqueResponse.class);

        Assert.assertTrue(object !=null);
    }

    @Test
    public void testObjectDriver() throws Exception {

        String path="D:\\data4.json";
        String content;

        content = new String(Files.readAllBytes(Paths.get(path)));
        String jsonString= content;
        // JSONArray inputArray = new JSONArray(jsonString);
        Gson gson = new Gson();

        FilaEmbarqueResponse.Carrier object = gson.fromJson(jsonString, FilaEmbarqueResponse.Carrier.class);

        Assert.assertTrue(object !=null);
    }

    /**
     * tes de todaas ka ¿s excepciones
     * @throws Exception
     */
    @Test
    public void TestArrayAll() throws Exception {

        String path="D:\\data5.json";
        String content;

        content = new String(Files.readAllBytes(Paths.get(path)));
        String jsonString= content;
        // JSONArray inputArray = new JSONArray(jsonString);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<FilaEmbarqueResponse>>() {}.getType();
        List<FilaEmbarqueResponse> object = gson.fromJson(jsonString, listType);

        Assert.assertTrue(object !=null);
    }

    @Test
    public void TestTodosLosDatos() throws Exception {

        String path="D:\\data6.json";
        String content;
        content = new String(Files.readAllBytes(Paths.get(path)));
        String jsonString= content;
        // JSONArray inputArray = new JSONArray(jsonString);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<FilaEmbarqueResponse>>() {}.getType();
        List<FilaEmbarqueResponse> object = gson.fromJson(jsonString, listType);

        Assert.assertTrue(object !=null);
    }
}