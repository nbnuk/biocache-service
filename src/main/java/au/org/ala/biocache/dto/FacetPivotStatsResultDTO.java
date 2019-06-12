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

import java.util.ArrayList;
import java.util.List;

/**
 * Group result for a SOLR search
 */
public class FacetPivotStatsResultDTO extends FacetPivotResultDTO {

    /**
     * Set of pivot results including statistics
     */
    private List<FacetPivotStatsResultDTO> pivotStatsResult;


    private String stats;


    /**
     * Constructor
     *
     * @param pivotField  Field used as a facet
     * @param pivotStatsResult Terms and counts returned from a facet search on this field
     */
    public FacetPivotStatsResultDTO(String pivotField, List<FacetPivotStatsResultDTO> pivotStatsResult) {
        super(pivotField, null);
        this.pivotStatsResult = pivotStatsResult;
    }

    public FacetPivotStatsResultDTO(String pivotField, List<FacetPivotStatsResultDTO> pivotStatsResult, String value, Integer count, String stats) {
        super(pivotField,null,value,count);
        this.pivotStatsResult = pivotStatsResult;
        this.stats = stats != null? stats : "";
    }

    /**
     * Default constructor
     */
    public FacetPivotStatsResultDTO() {
    }

    public List<FacetPivotStatsResultDTO> getPivotStatsResult() {
        return pivotStatsResult;
    }

    public void setPivotStatsResult(ArrayList<FacetPivotStatsResultDTO> pivotStatsResult) {
        this.pivotStatsResult = pivotStatsResult;
    }

    /**
     * @return the stats
     */
    public String getStats() {
        return stats;
    }

    /**
     * @param stats the stats to set
     */
    public void setStats(String stats) {
        this.stats = stats;
    }
}
