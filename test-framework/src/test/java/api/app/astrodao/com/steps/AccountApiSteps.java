package api.app.astrodao.com.steps;

import api.app.astrodao.com.core.annotations.Steps;
import api.app.astrodao.com.core.controllers.AccountApi;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

@Steps
@RequiredArgsConstructor
public class AccountApiSteps extends BaseSteps {
	private final AccountApi accountApi;

	@Step("Getting account settings by '{accountId}' query param")
	public Response getAccountSettingsById(String accountId) {
		return accountApi.getAccountSettingsById(accountId);
	}

	@Step("Set account email '{email}'")
	public Response setAccountEmail(String accountId, String publicKey, String signature, String email) {
		return accountApi.postAccountEmail(accountId, publicKey, signature, email);
	}

	@Step("Send account email verification code")
	public Response sendEmailVerificationCode(String accountId, String publicKey, String signature) {
		return accountApi.postSendEmailVerificationCode(accountId, publicKey, signature);
	}

	@Step("Verify email")
	public Response verifyEmail(String accountId, String publicKey, String signature, String code) {
		return accountApi.postVerifyEmail(accountId, publicKey, signature, code);
	}
}
