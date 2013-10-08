package nl.knaw.huygens.elaborate.publication;

import java.util.Date;
import java.util.List;

import nl.knaw.huygens.elaborate.publication.metadata.CmdiRecord;
import nl.knaw.huygens.elaborate.publication.metadata.DublinCoreRecord;
import nl.knaw.huygens.oaipmh.OAIRecord;
import nl.knaw.huygens.oaipmh.OAISet;
import nl.knaw.huygens.oaipmh.OaiPmhRestClient;

import com.google.common.collect.ImmutableList;

public class PublicationFinalizer {
  private static final String PREFIX = "oai:oaipmh.huygens.knaw.nl:elaborate:";

  public void finalizePublication() {
    // steps:
    // - move war to production
    // register persistent identifiers
    // generate metadata in oai & cmdi
    // send metadata to oaipmh server
    doOAI();
  }

  private void doOAI() {
    OaiPmhRestClient oai = new OaiPmhRestClient("http://127.0.0.1:9998/");
    String elab4editionSetSpec = "elaborate:edition";
    OAISet oaiSet = oai.getSet(elab4editionSetSpec);
    if (oaiSet == null) {
      oaiSet = new OAISet().setSetSpec(elab4editionSetSpec).setDescription("published elaborate editions").setSetName("elaborate edition");
      oai.postSet(oaiSet);
    }

    List<String> setSpecs = ImmutableList.of(elab4editionSetSpec);
    DublinCoreRecord dcRecord = new DublinCoreRecord();
    CmdiRecord cmdiRecord = new CmdiRecord();
    String metadata = dcRecord.asXML() + cmdiRecord.asXML();
    String id = "";
    Date datestamp = new Date();
    OAIRecord oaiRecord = new OAIRecord().setIdentifier(PREFIX + id).setSetSpecs(setSpecs).setMetadata(metadata).setDatestamp(datestamp);
    oai.postRecord(oaiRecord);

  }
}
