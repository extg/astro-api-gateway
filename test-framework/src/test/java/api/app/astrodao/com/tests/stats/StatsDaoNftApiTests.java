package api.app.astrodao.com.tests.stats;

import api.app.astrodao.com.core.dto.api.stats.StatsEntries;
import api.app.astrodao.com.steps.StatsApiSteps;
import api.app.astrodao.com.tests.BaseTest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import api.app.astrodao.com.core.enums.HttpStatus;

@Tags({@Tag("all"), @Tag("statsApiTests"), @Tag("statsDaoNftApiTests")})
@Epic("Stats")
@Feature("/stats/dao/{id}/nfts API tests")
@DisplayName("/stats/dao/{id}/nfts API tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StatsDaoNftApiTests extends BaseTest {
	private final StatsApiSteps statsApiSteps;

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Getting NFTs for a DAO")
	@DisplayName("Getting NFTs for a DAO")
	void gettingNFTsForDao() {
		//TODO: Add steps to retrieve data for DAO from CLI
		String dao = "gaming.sputnikv2.testnet";

		Response response = statsApiSteps.getNFTsForDao(dao);
		statsApiSteps.assertResponseStatusCode(response, HttpStatus.OK);

		StatsEntries statsEntries = statsApiSteps.getResponseDto(response, StatsEntries.class);

		statsApiSteps.assertCollectionHasSizeGreaterThanOrEqualTo(statsEntries, 3);
		statsApiSteps.assertCollectionElementsHasValue(statsEntries, r -> r.getValue().intValue() >= 0, "value");
		statsApiSteps.assertCollectionElementsHasValue(statsEntries, r -> !r.getTimestamp().toString().isBlank(), "timestamp");
	}
}
