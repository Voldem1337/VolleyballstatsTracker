package com.volleyballtracker.service;

/**
 * Service for exporting match statistics.
 *
 * Planned formats:
 * - PDF
 * - Excel
 * - Document
 * - JSON
 */

import com.volleyballtracker.model.ExportToPDF;
import com.volleyballtracker.model.Match;

/**
 * Service for exporting match statistics.
 */
public class ExportService {

    private final ExportToPDF exportToPDF;

    public ExportService() {
        this.exportToPDF = new ExportToPDF();
    }

    /** Creates PDF report for the given match. */
    public void exportToPdf(Match match) {
        exportToPDF.exportToPdf(match);
    }
}
