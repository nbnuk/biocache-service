/**************************************************************************
 *  Copyright (C) 2013 Atlas of Living Australia
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
package au.org.ala.biocache.util;

import au.org.ala.biocache.Store;
import au.org.ala.biocache.model.FullRecord;
import au.org.ala.biocache.model.Location;
import au.org.ala.biocache.parser.ProcessedValue;
import org.springframework.stereotype.Component;
import scala.Option;
import scala.Tuple2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("OccurrenceUtils")
public class OccurrenceUtils {

    /**
     * Retrieve occurrence record.
     *
     * @param uuid
     * @param includeSensitive
     * @return quality assertions
     */
    static public FullRecord[] getAllVersionsByUuid(String uuid, Boolean includeSensitive) {
        FullRecord [] occ = Store.getAllVersionsByUuid(uuid, includeSensitive);

        boolean isGeneralised = false;
        boolean isProcessed = true;
        if (occ != null) {
            int idx = 0;
            for (FullRecord fr : occ) {
                Location loc = fr.getLocation();
                if (loc != null && "null,null,null,null".equals(loc.getBbox())) {
                    loc.setBbox(null);
                }
                if (idx == 1) {
                    au.org.ala.biocache.model.Occurrence processed = fr.getOccurrence();
                    String generalisations = processed.getDataGeneralizations();
                    if (generalisations != null) {
                        if (generalisations != "" && !generalisations.contains("already generalised")) {
                            isGeneralised = true;
                        }
                    }
                }
                idx++;
            }
            if (isGeneralised) { //check record has been processed
                Location loc = occ[0].getLocation();
                if (loc != null) {
                    //if (any) raw values = originalsensitivevalues -> then record not processed so do not return it
                    au.org.ala.biocache.model.Occurrence raw = occ[0].getOccurrence();
                    scala.collection.immutable.Map<String, String> origSensitiveVals = raw.getOriginalSensitiveValues();
                    scala.collection.Iterator iter = origSensitiveVals.iterator();
                    while (iter.hasNext()) {
                        scala.Tuple2 sv = (Tuple2) iter.next();
                        String keySensitive = (String) sv._1;
                        String valSensitive = (String) sv._2;
                        String keyRaw = keySensitive.replace("_p","");
                        if (loc.hasProperty(keyRaw)) {
                            Option<String> valRaw = loc.getProperty(keyRaw);
                            if (valRaw.isDefined()) {
                                if (valRaw.get().equals(valSensitive)) {
                                    isProcessed = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isProcessed) {
            return occ;
        } else {
            return null;
        }
    }

    public static Map getComparisonByUuid(String uuid) {
        Map<String, List<ProcessedValue>> map = Store.getComparisonByUuid(uuid);

        if (map != null) {
            for (String type : map.keySet()) {
                if ("Location".equals(type)) {
                    for (ProcessedValue value : map.get(type)) {
                        if ("bbox".equals(value.getName())) {
                            if ("null,null,null,null".equals(value.getProcessed())) {
                                map.get(type).remove(value);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return map;
    }
}
