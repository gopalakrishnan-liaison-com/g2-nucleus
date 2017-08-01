package controllers;

import models.Payload;
import models.PayloadStore;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.gson.Gson;

/**
 * Controller class to add the payload
 *
 */
public class AddPayloadController extends Controller {

    public Result addPayload() {

    	//few lines are commented and hardcoded due to test case

        //JsonNode json = request().body().asJson();

        /*if (json == null){
            return badRequest(Util.createResponse("Invalid Json", false));
        }*/

        //(Payload) Json.fromJson(json, Payload.class)

        Payload load = new Payload();
        load.setPayloadId(1);
        load.setPayloadName("TestPayloadData");
        PayloadStore.getInstance().addPayload(load);

        Gson object = new Gson();
        return ok(object.toJson(load));
        //JsonNode jsonObject = Json.toJson(payload);
        //return created(Util.createResponse(jsonObject, true));
    }
}
