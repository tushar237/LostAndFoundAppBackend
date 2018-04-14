package com.techtransformers.lostnfound.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techtransformers.lostnfound.constants.LostAndFoundConstants;
import com.techtransformers.lostnfound.entity.LostAndFoundEntity;
import com.techtransformers.lostnfound.exceptions.LostAndFoundItemException;
import com.techtransformers.lostnfound.model.LostAndFound;
import com.techtransformers.lostnfound.processor.LostAndFoundProcessor;
import com.techtransformers.lostnfound.response.LostAndFoundItemResponse;
import com.techtransformers.lostnfound.service.LostAndFoundService;

@RestController
public class LostAndFoundController {

	@Autowired
	private LostAndFoundService lostAndFoundService;

	@RequestMapping(value = "/report/lost", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<LostAndFoundItemResponse> insertLostItem(@RequestBody LostAndFound lostItem)
			throws LostAndFoundItemException {

		LostAndFoundItemResponse lostAndFoundItemResponse = new LostAndFoundItemResponse();

		if (!StringUtils.isBlank(lostItem.getData().getEmail()) &&
				lostItem.getData().getCategory().equalsIgnoreCase(LostAndFoundConstants.LOST)) {
			LostAndFoundEntity lostItemEntity = LostAndFoundProcessor.convertLostItemBeanToEntity(lostItem);
			Integer lostItemId = lostAndFoundService.insertLostItem(lostItemEntity);

			if (null != lostItemId) {
				lostAndFoundItemResponse.setCode(HttpStatus.OK.value());
				lostAndFoundItemResponse.setMessage(LostAndFoundConstants.REGISTERED_SUCCESS);
			} else {
				throw new LostAndFoundItemException(LostAndFoundConstants.TRY_AGAIN);
			}

		} else {
			throw new LostAndFoundItemException(LostAndFoundConstants.TRY_AGAIN);
		}
		return new ResponseEntity<LostAndFoundItemResponse>(lostAndFoundItemResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/report/found", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<LostAndFoundItemResponse> insertFoundItem(@RequestBody LostAndFound foundItem)
			throws LostAndFoundItemException {

		LostAndFoundItemResponse lostAndFoundItemResponse = new LostAndFoundItemResponse();

		if (!StringUtils.isBlank(foundItem.getData().getEmail()) && 
				foundItem.getData().getCategory().equalsIgnoreCase(LostAndFoundConstants.FOUND)) {
			LostAndFoundEntity foundItemEntity = LostAndFoundProcessor.convertFoundItemBeanToEntity(foundItem);
			Integer foundItemId = lostAndFoundService.insertFoundItem(foundItemEntity);

			if (null != foundItemId) {
				lostAndFoundItemResponse.setCode(HttpStatus.OK.value());
				lostAndFoundItemResponse.setMessage(LostAndFoundConstants.REGISTERED_SUCCESS);
			} else {
				throw new LostAndFoundItemException(LostAndFoundConstants.TRY_AGAIN);
			}
		} else {
			throw new LostAndFoundItemException(LostAndFoundConstants.TRY_AGAIN);
		}
		return new ResponseEntity<LostAndFoundItemResponse>(lostAndFoundItemResponse, HttpStatus.OK);
	}

	@ExceptionHandler(LostAndFoundItemException.class)
	public ResponseEntity<LostAndFoundItemResponse> exceptionHandler(Exception exception) {
		LostAndFoundItemResponse error = new LostAndFoundItemResponse();
		error.setCode(Integer.valueOf(HttpStatus.PRECONDITION_FAILED.value()));
		error.setMessage(exception.getMessage());
		return new ResponseEntity<LostAndFoundItemResponse>(error, HttpStatus.OK);
	}

}
