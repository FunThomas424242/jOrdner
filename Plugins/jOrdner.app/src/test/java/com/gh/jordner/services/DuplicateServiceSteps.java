package com.gh.jordner.services;


public class DuplicateServiceSteps {

	// private Arbeitgeber arbeitgeber;
	// private Stellenangebot stellenangebot;
	//
	// public VermittlungsSteps() {
	// super();
	// }
	//
	// @AsParameterConverter
	// public Stellenangebot erstelleStellenangebot(String tokenName) {
	// if ("Stellenangebot".equals(tokenName)) {
	// return stellenangebot;
	// } else {
	// Assert.fail();
	// }
	// return null;
	// }
	//
	// @AsParameterConverter
	// public Arbeitgeber erstelleArbeitgeber(String tokenName) {
	// if ("Arbeitgeber".equals(tokenName)) {
	// return arbeitgeber;
	// } else {
	// Assert.fail();
	// }
	// return null;
	// }
	//
	// @Given("ein Arbeitgeber")
	// public Arbeitgeber registriereArbeitgeber() {
	// // Fehleranfälliger Punkt hier wäre NatSpec besser !!!
	// arbeitgeber = new Arbeitgeber();
	// return arbeitgeber;
	// }
	//
	// @When("dieser $Arbeitgeber registriert wurde")
	// public void istEinArbeitgeber(Arbeitgeber arbeitgeber) {
	// Assert.assertNotNull(arbeitgeber);
	// }
	//
	// @When("ein Stellenangebot vom $Arbeitgeber erstellt wurde")
	// public Stellenangebot erstelleStellenangebot(
	// @Named("Arbeitgeber") Arbeitgeber arbeitgeber) {
	// stellenangebot = this.arbeitgeber.erstelleStellenangebot();
	// return stellenangebot;
	// }
	//
	// @When("ein valides $Stellenangebot vorliegt")
	// public void istEinStellenangebot(
	// @Named("Stellenangebot") Stellenangebot stellenangebot) {
	// Assert.assertNotNull(stellenangebot);
	// }
	//
	// @When("das $Stellenangebot $anzahl Stelle zur Vermittlung bietet")
	// public void setzeMaxAnzahlStellen(
	// @Named("Stellenangebot") Stellenangebot stellenangebot,
	// @Named("anzahl") Integer anzahl) {
	// stellenangebot.setAnzahlStellen(anzahl);
	// }
	//
	// @Then("kann das $Stellenangebot noch auf $anzahl Stelle vermittelt werden")
	// public void vermittelbarAufStellen(
	// @Named("Stellenangebot") Stellenangebot stellenangebot,
	// @Named("anzahl") Integer anzahl) {
	// final Integer stellen = stellenangebot.getAnzahlStellen();
	// Assert.assertEquals(anzahl, stellen);
	// }

}
