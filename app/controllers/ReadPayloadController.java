package controllers;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.Payload;
import models.PayloadStore;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Controller class to list payload
 *
 */
public class ReadPayloadController extends Controller {

    public Result listPayload() {

        List<Payload> result = PayloadStore.getInstance().getPayloadData();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(Util.createResponse(jsonData, true));
    }
}
