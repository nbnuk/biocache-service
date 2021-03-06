/**************************************************************************
 *  Copyright (C) 2010 Atlas of Living Australia
 *  All Rights Reserved.
 * 
 *  The contents of this file are subject to the Mozilla Public
 *  License Version 1.1 (the "License"); you may not use this file
 *  except in compliance with the License. You may obtain a copy of
 *  the License at http://www.mozilla.org/MPL/
 * 
 *  Software distributed under the License is distributed on an "AS
 *  IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 *  implied. See the License for the specific language governing
 *  rights and limitations under the License.
 ***************************************************************************/
package au.org.ala.biocache.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.beans.Field;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A DTO representing an result from the search indexes.
 */
public class OccurrenceIndex {

    protected static final Logger logger = Logger.getLogger(OccurrenceIndex.class);

    @Field("id") String uuid;
    @Field("occurrence_id") String occurrenceID;
    //processed values
    @Field("data_hub_uid") String[] dataHubUid;
    @Field("data_hub") String dataHub;
    @Field("institution_uid") String institutionUid;
    @Field("institution_code") String raw_institutionCode;
    @Field("institution_name") String institutionName;
    @Field("collection_uid") String collectionUid;
    @Field("collection_code") String raw_collectionCode;
    @Field("collection_name") String collectionName;
    @Field("catalogue_number") String raw_catalogNumber;
    @Field("taxon_concept_lsid") String taxonConceptID;
    @Field("occurrence_date") java.util.Date eventDate;
    @Field("occurrence_date_end_dt") java.util.Date eventDateEnd;
    @Field("occurrence_year") java.util.Date occurrenceYear;
    @Field("vitality") String vitality;
    @Field("taxon_name") String scientificName;
    @Field("common_name") String vernacularName;
    @Field("rank") String taxonRank;
    @Field("rank_id") Integer taxonRankID;
    @Field("country_code") String raw_countryCode;
    @Field("country") String country;
    @Field("kingdom") String kingdom;
    @Field("phylum") String phylum;
    @Field("class") String classs;
    @Field("order") String order;
    @Field("family") String family;
    @Field("genus") String genus;
    @Field("genus_guid") String genusGuid;
    @Field("species") String species;
    @Field("species_guid") String speciesGuid;
    @Field("subspecies") String subspecies;
    @Field("subspecies_guid") String subspeciesGuid;
    @Field("life_stage") String[] lifeStage; // now Oct-19 multivalued
    @Field("state") String stateProvince;
    @Field("latitude") Double decimalLatitude;
    @Field("longitude") Double decimalLongitude;
    @Field("coordinate_uncertainty") Double coordinateUncertaintyInMeters;
    @Field("year") Integer year;
    @Field("month") String month;
    @Field("basis_of_record") String basisOfRecord;
    @Field("type_status") String typeStatus;
    @Field("location_remarks") String raw_locationRemarks;
    @Field("occurrence_remarks") String raw_occurrenceRemarks;
    @Field("lft") Integer left;
    @Field("rgt") Integer right;
    @Field("ibra") String ibra;
    @Field("imcra") String imcra;
    @Field("places") String lga;
    @Field("data_provider_uid") String dataProviderUid;
    @Field("data_provider") String dataProviderName;
    @Field("data_resource_uid") String dataResourceUid;
    @Field("data_resource") String dataResourceName;
    @Field("assertions") String[] assertions;
    @Field("user_assertions") String hasUserAssertions;
    @Field("species_group") String[] speciesGroups;
    @Field("image_url") String image;
    @Field("all_image_url") String[] images;
    @Field("geospatial_kosher") String geospatialKosher;
    @Field("taxonomic_kosher") String taxonomicKosher;
    @Field("collector") String collector;
    @Field("collectors") String[] collectors;
    //extra raw record fields
    @Field("raw_taxon_name") String raw_scientificName;
    @Field("raw_basis_of_record") String raw_basisOfRecord;
    @Field("raw_type_status") String raw_typeStatus;
    @Field("raw_common_name") String raw_vernacularName;    
    //constructed fields
    @Field("lat_long") String latLong;
    @Field("point-1") String point1;
    @Field("point-0.1") String point01;
    @Field("point-0.01") String point001;
    @Field("point-0.001") String point0001;
    @Field("point-0.0001") String point00001;
    @Field("names_and_lsid") String namesLsid;
    @Field("multimedia") String[] multimedia;
    @Field("license") String license;
    @Field("identification_verification_status") String identificationVerificationStatus;
    //conservation status field
    @Field("aust_conservation") String austConservation;
    @Field("state_conservation") String stateConservation;
    @Field("sensitive") String sensitive;
    //AVH extra fields
    @Field("record_number") String recordNumber;
    //For harvesting of images into the BIE
    @Field("occurrence_details") String occurrenceDetails;
    @Field("rights") String rights; 
    @Field("photographer_s") String photographer;
    @Field("grid_ref") String gridReference;
    @Field("location_id") String locationId;
    @Field("raw_taxon_id") String raw_taxonId;
    @Field("raw_sampling_protocol") String raw_samplingProtocol;
    @Field("*_s") Map<String, Object> miscStringProperties;
    @Field("*_i") Map<String, Object> miscIntProperties;
    @Field("*_d") Map<String, Object> miscDoubleProperties;
    @Field("*_dt") Map<String, Object> miscDateProperties;
    List<Map<String, Object>> imageMetadata;

    String imageUrl;
    String largeImageUrl;
    String smallImageUrl;
    String thumbnailUrl;
    String[] imageUrls;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }
    
    public String[] getImageUrls(){
        return imageUrls;
    }

    public String getLargeImageUrl(){
        return largeImageUrl;
    }
    
    public void setImageUrls(String[] urls){
        this.imageUrls = urls;
    }

    public String getSmallImageUrl(){
        return smallImageUrl;
    }

    public String getThumbnailUrl(){
        return thumbnailUrl;
    }

    private void addToMapIfNotNull(Map<String,String> map, String key, String value){
        if(value != null && value != ""){
            map.put(key,value);
        }
    }
    
    private String safeDblToString(Double d){
        if(d != null) return d.toString();
        return null;
    }

    private String safeIntToString(Integer d){
        if(d != null) return d.toString();
        return null;
    }

    private String arrToString(String[] arr){
        try{
            if(arr != null) {
                ObjectMapper o = new ObjectMapper();
                return o.writeValueAsString(arr);
            }
        }catch(Exception e){}
        return null;
    }    
    
    @JsonIgnore
    public Map<String,String> toMap() {
        String sdate = null;
        if(eventDate != null) {
            sdate = DateFormatUtils.format(eventDate, "yyyy-MM-dd");
        }
        String sdateEnd = null;
        if(eventDateEnd != null) {
            sdate = DateFormatUtils.format(eventDateEnd, "yyyy-MM-dd");
        }
        Map<String,String> map = new HashMap<String,String>();
        addToMapIfNotNull(map, "id", uuid);
        addToMapIfNotNull(map, "occurrence_id",occurrenceID);
        addToMapIfNotNull(map, "data_hub_uid",arrToString(dataHubUid));
        addToMapIfNotNull(map, "data_hub" ,dataHub);
        addToMapIfNotNull(map, "institution_uid", institutionUid);
        addToMapIfNotNull(map, "institution_code", raw_institutionCode);
        addToMapIfNotNull(map, "institution_name", institutionName);
        addToMapIfNotNull(map, "collection_uid", collectionUid);
        addToMapIfNotNull(map, "collection_code", raw_collectionCode);
        addToMapIfNotNull(map, "collection_name",collectionName);
        addToMapIfNotNull(map, "catalogue_number",raw_catalogNumber);
        addToMapIfNotNull(map, "taxon_concept_lsid",taxonConceptID);
        addToMapIfNotNull(map, "occurrence_date", sdate);
        addToMapIfNotNull(map, "occurrence_date_end_dt", sdateEnd);
        addToMapIfNotNull(map, "vitality", vitality);
        addToMapIfNotNull(map, "taxon_name",scientificName);
        addToMapIfNotNull(map, "common_name",vernacularName);
        addToMapIfNotNull(map, "rank",taxonRank);
        addToMapIfNotNull(map, "rank_id",safeIntToString(taxonRankID));
        addToMapIfNotNull(map, "life_stage", arrToString(lifeStage)); //multivalued
        addToMapIfNotNull(map, "country_code", raw_countryCode);
        addToMapIfNotNull(map, "country", country);
        addToMapIfNotNull(map, "kingdom",kingdom); 
        addToMapIfNotNull(map, "phylum", phylum);
        addToMapIfNotNull(map, "class", classs); 
        addToMapIfNotNull(map, "order", order); 
        addToMapIfNotNull(map, "family", family);
        addToMapIfNotNull(map, "genus",genus);
        addToMapIfNotNull(map, "genus_guid",genusGuid);
        addToMapIfNotNull(map, "species", species);
        addToMapIfNotNull(map, "species_guid", speciesGuid);
        addToMapIfNotNull(map, "subspecies", subspecies);
        addToMapIfNotNull(map, "subspecies_guid", subspeciesGuid);
        addToMapIfNotNull(map, "state", stateProvince); 
        addToMapIfNotNull(map, "latitude", safeDblToString(decimalLatitude));
        addToMapIfNotNull(map, "longitude", safeDblToString(decimalLongitude)); 
        addToMapIfNotNull(map, "year", safeIntToString(year));
        addToMapIfNotNull(map, "month", month); 
        addToMapIfNotNull(map, "basis_of_record", basisOfRecord);
        addToMapIfNotNull(map, "type_status", typeStatus); 
        addToMapIfNotNull(map, "location_remarks", raw_locationRemarks); 
        addToMapIfNotNull(map, "occurrence_remarks", raw_occurrenceRemarks);
        addToMapIfNotNull(map, "lft", safeIntToString(left)); 
        addToMapIfNotNull(map, "rgt", safeIntToString(right));
        addToMapIfNotNull(map, "ibra", ibra); 
        addToMapIfNotNull(map, "imcra", imcra);
        addToMapIfNotNull(map, "places", lga); 
        addToMapIfNotNull(map, "data_provider_uid", dataProviderUid); 
        addToMapIfNotNull(map, "data_provider", dataProviderName);
        addToMapIfNotNull(map, "data_resource_uid", dataResourceUid);
        addToMapIfNotNull(map, "data_resource", dataResourceName); 
        addToMapIfNotNull(map, "assertions", arrToString(assertions));
        addToMapIfNotNull(map, "user_assertions", hasUserAssertions); 
        addToMapIfNotNull(map, "species_group", arrToString(speciesGroups));
        addToMapIfNotNull(map, "image_url", image); 
        addToMapIfNotNull(map, "geospatial_kosher", geospatialKosher); 
        addToMapIfNotNull(map, "taxonomic_kosher", taxonomicKosher);
        addToMapIfNotNull(map, "raw_taxon_name", raw_scientificName); 
        addToMapIfNotNull(map, "raw_basis_of_record", raw_basisOfRecord);
        addToMapIfNotNull(map, "raw_type_status", raw_typeStatus); 
        addToMapIfNotNull(map, "raw_common_name", raw_vernacularName); 
        addToMapIfNotNull(map, "lat_long", latLong);
        addToMapIfNotNull(map, "point-1", point1); 
        addToMapIfNotNull(map, "point-0.1", point01); 
        addToMapIfNotNull(map, "point-0.01", point001); 
        addToMapIfNotNull(map, "point-0.001", point0001);
        addToMapIfNotNull(map, "point-0.0001", point00001); 
        addToMapIfNotNull(map, "names_and_lsid", namesLsid); 
        addToMapIfNotNull(map, "multimedia", arrToString(multimedia));
        addToMapIfNotNull(map, "collector",collector);
        addToMapIfNotNull(map, "collectors",arrToString(collectors));
        addToMapIfNotNull(map, "record_number", recordNumber);
        addToMapIfNotNull(map, "occurrence_details", occurrenceDetails);
        addToMapIfNotNull(map, "rights", rights);
        addToMapIfNotNull(map, "photographer_s", photographer);
        addToMapIfNotNull(map, "license", license);
        addToMapIfNotNull(map, "grid_ref", gridReference);
        addToMapIfNotNull(map, "location_id", locationId);
        addToMapIfNotNull(map, "identification_verification_status", identificationVerificationStatus);
        addToMapIfNotNull(map, "raw_taxon_id", raw_taxonId);
        addToMapIfNotNull(map, "raw_sampling_protocol", raw_samplingProtocol);
        return map;
    }

    @JsonIgnore
    public Map<String,String> indexToJsonMap() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("id", "uuid");
        map.put("occurrence_id", "occurrenceID");
        map.put("data_hub_uid","dataHubUid");
        map.put("data_hub" ,"dataHub");
        map.put("institution_uid", "institutionUid");
        map.put("institution_code", "raw_institutionCode");
        map.put("institution_name", "institutionName");
        map.put("collection_uid", "collectionUid");
        map.put("collection_code", "raw_collectionCode");
        map.put("collection_name","collectionName");
        map.put("catalogue_number","raw_catalogNumber");
        map.put("taxon_concept_lsid","taxonConceptID");
        map.put("occurrence_date", "eventDate");
        map.put("occurrence_date_end_dt", "eventDateEnd");
        map.put("vitality", "vitality");
        map.put("taxon_name","scientificName");
        map.put("common_name","vernacularName");
        map.put("rank","taxonRank");
        map.put("rank_id","taxonRankID");
        map.put("life_stage", "lifeStage");
        map.put("country_code", "raw_countryCode");
        map.put("country", "country");
        map.put("kingdom","kingdom");
        map.put("phylum", "phylum");
        map.put("class", "classs");
        map.put("order","order");
        map.put("family","family");
        map.put("genus","genus");
        map.put("genus_guid","genusGuid");
        map.put("species", "species");
        map.put("species_guid", "speciesGuid");
        map.put("subspecies", "subspecies");
        map.put("subspecies_guid", "subspeciesGuid");
        map.put("state", "stateProvince");
        map.put("latitude", "decimalLatitude");
        map.put("longitude", "decimalLongitude");
        map.put("year", "year");
        map.put("month","month");
        map.put("basis_of_record", "basisOfRecord");
        map.put("type_status", "typeStatus");
        map.put("location_remarks", "raw_locationRemarks");
        map.put("occurrence_remarks", "raw_occurrenceRemarks");
        map.put("lft","left");
        map.put("rgt", "right");
        map.put("ibra", "ibra");
        map.put("imcra", "imcra");
        map.put("places", "lga");
        map.put("data_provider_uid", "dataProviderUid");
        map.put("data_provider", "dataProviderName");
        map.put("data_resource_uid", "dataResourceUid");
        map.put("data_resource", "dataResourceName");
        map.put("assertions", "assertions");
        map.put("user_assertions", "hasUserAssertions");
        map.put("species_group", "speciesGroups");
        map.put("image_url", "image");
        map.put("geospatial_kosher", "geospatialKosher");
        map.put("taxonomic_kosher", "taxonomicKosher");
        map.put("raw_taxon_name", "raw_scientificName");
        map.put("raw_basis_of_record", "raw_basisOfRecord");
        map.put("raw_type_status", "raw_typeStatus");
        map.put("raw_common_name", "raw_vernacularName");
        map.put("lat_long", "latLong");
        map.put("point-1", "point1");
        map.put("point-0.1", "point01");
        map.put("point-0.01", "point001");
        map.put("point-0.001", "point0001");
        map.put("point-0.0001", "point00001");
        map.put("names_and_lsid", "namesLsid");
        map.put("multimedia", "multimedia");
        map.put("collector","collector");
        map.put("collectors","collectors");
        map.put("record_number", "recordNumber");
        map.put("occurrence_details", "occurrenceDetails");
        map.put("rights", "rights");
        map.put("photographer_s", "photographer");
        map.put("license", "license");
        map.put("grid_ref", "gridReference");
        map.put("location_id", "locationId");
        map.put("raw_taxon_id", "raw_taxonId");
        map.put("raw_sampling_protocol", "raw_samplingProtocol");
        return map;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOccurrenceID() {
        return occurrenceID;
    }

    public void setOccurrenceID(String occurrenceID) {
        this.occurrenceID = occurrenceID;
    }

    public String[] getDataHubUid() {
        return dataHubUid;
    }

    public void setDataHubUid(String[] dataHubUid) {
        this.dataHubUid = dataHubUid;
    }

    public String getDataHub() {
        return dataHub;
    }

    public void setDataHub(String dataHub) {
        this.dataHub = dataHub;
    }

    public String getInstitutionUid() {
        return institutionUid;
    }

    public void setInstitutionUid(String institutionUid) {
        this.institutionUid = institutionUid;
    }

    public String getRaw_institutionCode() {
        return raw_institutionCode;
    }

    public void setRaw_institutionCode(String raw_institutionCode) {
        this.raw_institutionCode = raw_institutionCode;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getCollectionUid() {
        return collectionUid;
    }

    public void setCollectionUid(String collectionUid) {
        this.collectionUid = collectionUid;
    }

    public String getRaw_collectionCode() {
        return raw_collectionCode;
    }

    public void setRaw_collectionCode(String raw_collectionCode) {
        this.raw_collectionCode = raw_collectionCode;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getRaw_catalogNumber() {
        return raw_catalogNumber;
    }

    public void setRaw_catalogNumber(String raw_catalogNumber) {
        this.raw_catalogNumber = raw_catalogNumber;
    }

    public String getTaxonConceptID() {
        return taxonConceptID;
    }

    public void setTaxonConceptID(String taxonConceptID) {
        this.taxonConceptID = taxonConceptID;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getEventDateEnd() {
        return eventDateEnd;
    }

    public void setEventDateEnd(Date eventDateEnd) {
        this.eventDateEnd = eventDateEnd;
    }

    public Date getOccurrenceYear() {
        return occurrenceYear;
    }

    public void setOccurrenceYear(Date occurrenceYear) {
        this.occurrenceYear = occurrenceYear;
    }

    public String getVitality() {
        return vitality;
    }

    public void setVitality(String vitality) {
        this.vitality = vitality;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getVernacularName() {
        return vernacularName;
    }

    public void setVernacularName(String vernacularName) {
        this.vernacularName = vernacularName;
    }

    public String getTaxonRank() {
        return taxonRank;
    }

    public void setTaxonRank(String taxonRank) {
        this.taxonRank = taxonRank;
    }

    public Integer getTaxonRankID() {
        return taxonRankID;
    }

    public void setTaxonRankID(Integer taxonRankID) {
        this.taxonRankID = taxonRankID;
    }

    public String getRaw_countryCode() {
        return raw_countryCode;
    }

    public void setRaw_countryCode(String raw_countryCode) {
        this.raw_countryCode = raw_countryCode;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public String getPhylum() {
        return phylum;
    }

    public void setPhylum(String phylum) {
        this.phylum = phylum;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getGenusGuid() {
        return genusGuid;
    }

    public void setGenusGuid(String genusGuid) {
        this.genusGuid = genusGuid;
    }
    
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpeciesGuid() {
        return speciesGuid;
    }

    public void setSpeciesGuid(String speciesGuid) {
        this.speciesGuid = speciesGuid;
    }
    
    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }
    
    public String getSubspeciesGuid() {
        return subspeciesGuid;
    }

    public void setSubspeciesGuid(String subspeciesGuid) {
        this.subspeciesGuid = subspeciesGuid;
    }

    public String[] getLifeStage() { return lifeStage; } //multivalued

    public void setLifeStage(String[] lifeStage) { this.lifeStage = lifeStage; }
    
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Double getDecimalLatitude() {
        return decimalLatitude;
    }

    public void setDecimalLatitude(Double decimalLatitude) {
        this.decimalLatitude = decimalLatitude;
    }

    public Double getDecimalLongitude() {
        return decimalLongitude;
    }

    public void setDecimalLongitude(Double decimalLongitude) {
        this.decimalLongitude = decimalLongitude;
    }

    public Double getCoordinateUncertaintyInMeters() {
        return coordinateUncertaintyInMeters;
    }

    public void setCoordinateUncertaintyInMeters(Double coordinateUncertaintyInMeters) {
        this.coordinateUncertaintyInMeters = coordinateUncertaintyInMeters;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getBasisOfRecord() {
        return basisOfRecord;
    }

    public void setBasisOfRecord(String basisOfRecord) {
        this.basisOfRecord = basisOfRecord;
    }

    public String getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }

    public String getRaw_locationRemarks() {
        return raw_locationRemarks;
    }

    public void setRaw_locationRemarks(String raw_locationRemarks) {
        this.raw_locationRemarks = raw_locationRemarks;
    }

    public String getRaw_occurrenceRemarks() {
        return raw_occurrenceRemarks;
    }

    public void setRaw_occurrenceRemarks(String raw_occurrenceRemarks) {
        this.raw_occurrenceRemarks = raw_occurrenceRemarks;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public String getIbra() {
        return ibra;
    }

    public void setIbra(String ibra) {
        this.ibra = ibra;
    }

    public String getImcra() {
        return imcra;
    }

    public void setImcra(String imcra) {
        this.imcra = imcra;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getDataProviderUid() {
        return dataProviderUid;
    }

    public void setDataProviderUid(String dataProviderUid) {
        this.dataProviderUid = dataProviderUid;
    }

    public String getDataProviderName() {
        return dataProviderName;
    }

    public void setDataProviderName(String dataProviderName) {
        this.dataProviderName = dataProviderName;
    }

    public String getDataResourceUid() {
        return dataResourceUid;
    }

    public void setDataResourceUid(String dataResourceUid) {
        this.dataResourceUid = dataResourceUid;
    }

    public String getDataResourceName() {
        return dataResourceName;
    }

    public void setDataResourceName(String dataResourceName) {
        this.dataResourceName = dataResourceName;
    }

    public String[] getAssertions() {
        return assertions;
    }

    public void setAssertions(String[] assertions) {
        this.assertions = assertions;
    }

    public String getHasUserAssertions() {
        return hasUserAssertions;
    }

    public void setHasUserAssertions(String hasUserAssertions) {
        this.hasUserAssertions = hasUserAssertions;
    }

    public String[] getSpeciesGroups() {
        return speciesGroups;
    }

    public void setSpeciesGroups(String[] speciesGroups) {
        this.speciesGroups = speciesGroups;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String[] getImages(){
        return images;
    }
    
    public void setImages(String[] images){
        this.images = images;
    }

    public String getGeospatialKosher() {
        return geospatialKosher;
    }

    public void setGeospatialKosher(String geospatialKosher) {
        this.geospatialKosher = geospatialKosher;
    }

    public String getTaxonomicKosher() {
        return taxonomicKosher;
    }

    public void setTaxonomicKosher(String taxonomicKosher) {
        this.taxonomicKosher = taxonomicKosher;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public String getRaw_scientificName() {
        return raw_scientificName;
    }

    public void setRaw_scientificName(String raw_scientificName) {
        this.raw_scientificName = raw_scientificName;
    }

    public String getRaw_basisOfRecord() {
        return raw_basisOfRecord;
    }

    public void setRaw_basisOfRecord(String raw_basisOfRecord) {
        this.raw_basisOfRecord = raw_basisOfRecord;
    }

    public String getRaw_typeStatus() {
        return raw_typeStatus;
    }

    public void setRaw_typeStatus(String raw_typeStatus) {
        this.raw_typeStatus = raw_typeStatus;
    }

    public String getRaw_vernacularName() {
        return raw_vernacularName;
    }

    public void setRaw_vernacularName(String raw_vernacularName) {
        this.raw_vernacularName = raw_vernacularName;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public String getPoint1() {
        return point1;
    }

    public void setPoint1(String point1) {
        this.point1 = point1;
    }

    public String getPoint01() {
        return point01;
    }

    public void setPoint01(String point01) {
        this.point01 = point01;
    }

    public String getPoint001() {
        return point001;
    }

    public void setPoint001(String point001) {
        this.point001 = point001;
    }

    public String getPoint0001() {
        return point0001;
    }

    public void setPoint0001(String point0001) {
        this.point0001 = point0001;
    }

    public String getPoint00001() {
        return point00001;
    }

    public void setPoint00001(String point00001) {
        this.point00001 = point00001;
    }

    public String getNamesLsid() {
        return namesLsid;
    }

    public void setNamesLsid(String namesLsid) {
        this.namesLsid = namesLsid;
    }

    public String[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String[] multimedia) {
        this.multimedia = multimedia;
    }

    public String getAustConservation() {
        return austConservation;
    }

    public void setAustConservation(String austConservation) {
        this.austConservation = austConservation;
    }

    public String getStateConservation() {
        return stateConservation;
    }

    public void setStateConservation(String stateConservation) {
        this.stateConservation = stateConservation;
    }

    /**
     * @return the sensitive
     */
    public String getSensitive() {
        return sensitive;
    }

    /**
     * @param sensitive the sensitive to set
     */
    public void setSensitive(String sensitive) {
        this.sensitive = sensitive;
    }

    /**
     * @return the collector
     */
    public String[] getCollectors() {
        return collectors;
    }

    /**
     * @param collectors the collector to set
     */
    public void setCollectors(String[] collectors) {
        this.collectors = collectors;
    }

    /**
     * @return the recordNumber
     */
    public String getRecordNumber() {
        return recordNumber;
    }

    /**
     * @param recordNumber the recordNumber to set
     */
    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }
    
    /**
     * @return the occurrence details
     */
    public String getOccurrenceDetails() {
        return occurrenceDetails;
    }

    /**
     * @param occurrenceDetails the occurrence details
     */
    public void setOccurrenceDetails(String occurrenceDetails) {
        this.occurrenceDetails = occurrenceDetails;
    }

    /**
     * @return rights information
     */
    public String getRights() {
        return rights;
    }

    /**
     * @param rights rights information
     */
    public void setRights(String rights) {
        this.rights = rights;
    }

    /**
     * @return photographer of the occurrence
     */
    public String getPhotographer() {
        return photographer;
    }

    /**
     * @param photographer photographer of the occurrence
     */
    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public List<Map<String, Object>> getImageMetadata() {
        return imageMetadata;
    }

    public void setImageMetadata(List<Map<String, Object>> imageMetadata) {
        this.imageMetadata = imageMetadata;
    }

    public Map<String, Object> getMiscStringProperties() {
        return miscStringProperties;
    }

    public void setMiscStringProperties(Map<String, Object> miscStringProperties) {
        this.miscStringProperties = miscStringProperties;
    }

    public Map<String, Object> getMiscIntProperties() {
        return miscIntProperties;
    }

    public void setMiscIntProperties(Map<String, Object> miscIntProperties) {
        this.miscIntProperties = miscIntProperties;
    }

    public Map<String, Object> getMiscDoubleProperties() {
        return miscDoubleProperties;
    }

    public void setMiscDoubleProperties(Map<String, Object> miscDoubleProperties) {
        this.miscDoubleProperties = miscDoubleProperties;
    }

    public String getGridReference() {
        return gridReference;
    }

    public void setGridReference(String gridReference) {
        this.gridReference = gridReference;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Map<String, Object> getMiscDateProperties() {
        return miscDateProperties;
    }

    public void setMiscDateProperties(Map<String, Object> miscDateProperties) {
        this.miscDateProperties = miscDateProperties;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getIdentificationVerificationStatus() {
        return identificationVerificationStatus;
}

    public void setIdentificationVerificationStatus(String identificationVerificationStatus) {
        this.identificationVerificationStatus = identificationVerificationStatus;
    }

    public String getRaw_taxonId() {
        return raw_taxonId;
    }

    public void setRaw_taxonId(String raw_taxonId) {
        this.raw_taxonId = raw_taxonId;
    }

    public String getRaw_samplingProtocol() {
        return raw_samplingProtocol;
    }

    public void setRaw_samplingProtocol(String raw_samplingProtocol) {
        this.raw_samplingProtocol = raw_samplingProtocol;
    }
}
