package com.jana.solid.paymentsystem;

import java.util.Map;
import java.util.Objects;

public class PaymentService {
	NotificationService notificationService;
	Map<PaymentType, Payment> paymentMethods;

	public PaymentService(Map<PaymentType, Payment> paymentMethods, NotificationService notificationService) {
		this.notificationService = notificationService;
		this.paymentMethods = paymentMethods;
	}

	public PaymentResult makePayment(PaymentRequest request) {
		validate(request);
		Payment payment = paymentMethods.get(request.type());

		if (payment == null) {
			throw new IllegalArgumentException("Unsupported Payment Type");
		}
		PaymentResult result = payment.pay(request);
		if (Boolean.TRUE.equals(result.status())) {
			notificationService.send(result);
		}
		return result;

	}

	private void validate(PaymentRequest request) {

		if (Objects.isNull(request)) {
			throw new IllegalArgumentException("Invalid Request");
		} else if (Objects.isNull(request.accName())) {
			throw new IllegalArgumentException("Invalid Account Name");
		} else if (Objects.isNull(request.amt()) || request.amt()<=0) {
			throw new IllegalArgumentException("Invalid Amount");
		} else if (Objects.isNull(request.type())) {
			throw new IllegalArgumentException("Invalid Payment Type");
		}
	}

}
