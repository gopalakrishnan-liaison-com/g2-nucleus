package controllers;


import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;
import models.Payload;

import org.junit.Assert;
import org.junit.Test;

import play.mvc.Result;

import com.google.gson.Gson;

/**
 * IT saple test case for adding the data
 *
 */
public class PayloadITest {

	@Test
	public void addAndGetPayload() {

		//Adding the payload which already avail in controller
		AddPayloadController addCtrlr = new AddPayloadController();
		Result result = addCtrlr.addPayload();
		Assert.assertEquals(OK, result.status());
		String resultData = contentAsString(result);

		Gson gson = new Gson();
		Payload data = gson.fromJson(resultData, Payload.class);
		Assert.assertEquals(1, data.getPayloadId());
		Assert.assertEquals("TestPayloadData", data.getPayloadName());

		//Retrieving the payload data
		ReadPayloadController readCtrlr = new ReadPayloadController();
		Result readResult = readCtrlr.listPayload();
		Assert.assertEquals(OK, readResult.status());
		Assert.assertTrue(contentAsString(readResult).contains("TestPayloadData"));

		//clearing all the payload data
		RemovePayloadController removeCtrlr = new RemovePayloadController();
		Result removeResult = removeCtrlr.removePayload();
		Assert.assertEquals(OK, removeResult.status());
		Assert.assertTrue(contentAsString(removeResult).contains("Payloads Deleted successfully"));
	}

}
