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
public class ExportService {

    /** Main export method that chooses format. */
    public void exportMatch() {
        // TODO: Select correct export method by format.
    }

    /** Creates PDF report. */
    public void exportToPdf() {
        // TODO: Generate PDF with match title, player statistics, and diagrams.
    }

    /** Saves match as JSON. */
    public void exportToJson() {
        // TODO: Save Match object to JSON file.
    }

    /** Creates Excel report. */
    public void exportToExcel() {
        // TODO: Generate Excel file with statistics tables.
    }

    /** Prepares data for export reports. */
    public void createExportReportData() {
        // TODO: Convert Match data into report-friendly format.
    }

    /** Creates a diagram for export. */
    public void createDiagram() {
        // TODO: Generate chart image for PDF/Excel.
    }
}
