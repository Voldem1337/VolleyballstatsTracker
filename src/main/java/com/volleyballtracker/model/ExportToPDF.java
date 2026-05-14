package com.volleyballtracker.model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ExportToPDF {

    private static final Font TITLE_FONT = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static final Font HEADER_FONT = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
    private static final Font SECTION_FONT = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
    private static final Font NORMAL_FONT = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
    private static final Font SMALL_FONT = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL);

    public void exportToPdf(Match match) {
        try {
            Path exportFolder = Path.of("src", "main", "resources", "data", "exports");
            if (!Files.exists(exportFolder)) {
                Files.createDirectories(exportFolder);
            }

            String fileName = match.getFileName().replace(".json", "") + "_export.pdf";
            Path outputPath = exportFolder.resolve(fileName);

            Document document = new Document(PageSize.A4, 40, 40, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream(outputPath.toFile()));
            document.open();

            addMatchInfo(document, match);
            addDivider(document);
            addTeamStats(document, match);
            addDivider(document);
            addChart(document, match);

            document.close();

            System.out.println("PDF exported to: " + outputPath.toAbsolutePath());

        } catch (Exception e) {
            throw new RuntimeException("Could not export PDF", e);
        }
    }

    private void addMatchInfo(Document doc, Match match) throws DocumentException {
        // Header
        Paragraph title = new Paragraph(match.getMatchName(), TITLE_FONT);
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);
        doc.add(Chunk.NEWLINE);

        // Information
        Paragraph info = new Paragraph();
        info.add(new Chunk("Match info:\n", HEADER_FONT));
        info.add(new Chunk("Date: " + (match.getDate() != null ? match.getDate() : "...") + "\n", NORMAL_FONT));

        // Score
        StringBuilder score = new StringBuilder("Score: ");
        List<Set> sets = match.getSets();
        for (int i = 0; i < sets.size(); i++) {
            Set s = sets.get(i);
            score.append(s.getTeamOnePoints()).append(":").append(s.getTeamTwoPoints());
            if (i < sets.size() - 1) score.append(", ");
        }
        info.add(new Chunk(score.toString() + "\n", NORMAL_FONT));
        info.add(new Chunk("Result: " + match.getWhoWon() + "\n", NORMAL_FONT));
        doc.add(info);
    }

    private void addTeamStats(Document doc, Match match) throws DocumentException {
        // Team1
        addTeamHeader(doc, match.getTeamOneName());
        addPlayerStats(doc, match.getPlayer1(), match.getPlayer2());

        doc.newPage();

        // Team2
        addTeamHeader(doc, match.getTeamTwoName());
        addPlayerStats(doc, match.getPlayer3(), match.getPlayer4());
    }

    private void addTeamHeader(Document doc, String teamName) throws DocumentException {
        Paragraph header = new Paragraph(teamName, HEADER_FONT);
        header.setSpacingBefore(8);
        doc.add(header);
    }

    private void addPlayerStats(Document doc, Player p1, Player p2) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setSpacingBefore(6);

        table.addCell(playerCell(p1));
        table.addCell(playerCell(p2));

        doc.add(table);
    }

    private PdfPCell playerCell(Player p) {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPadding(4);

        Paragraph content = new Paragraph();
        content.add(new Chunk(p.getName() + " (" + p.getPosition() + ")\n", SECTION_FONT));

        // Attack
        int attackTotal = p.getSpikeAttempt() + p.getCutShotAttempt();
        int attackKills = p.getSpikeKill() + p.getCutShotKill();
        int attackErrors = p.getSpikeError() + p.getCutShotError();
        double attackPct = attackTotal > 0 ? (double) attackKills / attackTotal * 100 : 0;

        content.add(new Chunk("\nAttack\n", SECTION_FONT));
        content.add(new Chunk("Attempts: " + attackTotal + "\n", SMALL_FONT));
        content.add(new Chunk("Kills: " + attackKills + "\n", SMALL_FONT));
        content.add(new Chunk("Errors: " + attackErrors + "\n", SMALL_FONT));
        content.add(new Chunk(String.format("Success: %.0f%%\n", attackPct), SMALL_FONT));

        // Receive
        int receiveTotal = p.getGoodReceive() + p.getReceiveForTheOption() + p.getHardToSet() + p.getReceiveError();
        int goodReceive = p.getGoodReceive() + p.getReceiveForTheOption();
        double receivePct = receiveTotal > 0 ? (double) goodReceive / receiveTotal * 100 : 0;

        content.add(new Chunk("\nReceive\n", SECTION_FONT));
        content.add(new Chunk("Good: " + goodReceive + "\n", SMALL_FONT));
        content.add(new Chunk("Errors: " + p.getReceiveError() + "\n", SMALL_FONT));
        content.add(new Chunk(String.format("Success: %.0f%%\n", receivePct), SMALL_FONT));

        // Block
        content.add(new Chunk("\nBlock\n", SECTION_FONT));
        content.add(new Chunk("Touches: " + p.getBlockTouch() + "\n", SMALL_FONT));
        content.add(new Chunk("Points: " + p.getMonsterBlock() + "\n", SMALL_FONT));
        content.add(new Chunk("Errors: " + p.getBlockError() + "\n", SMALL_FONT));

        // Dig
        content.add(new Chunk("\nDig\n", SECTION_FONT));
        content.add(new Chunk("Successful: " + p.getDig() + "\n", SMALL_FONT));
        content.add(new Chunk("Errors: " + p.getDigError() + "\n", SMALL_FONT));

        cell.addElement(content);
        return cell;
    }

    private void addChart(Document doc, Match match) throws DocumentException, IOException {
        Paragraph chartTitle = new Paragraph("Player Overview", HEADER_FONT);
        chartTitle.setSpacingBefore(10);
        doc.add(chartTitle);

        //Sheet
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setSpacingBefore(6);
        table.setWidths(new float[]{3, 1.5f, 1.5f, 1.5f, 1.5f});

        addHeaderCell(table, "Player");
        addHeaderCell(table, "Attack %");
        addHeaderCell(table, "Receive %");
        addHeaderCell(table, "Block pts");
        addHeaderCell(table, "Dig");

        addPlayerRow(table, match.getPlayer1());
        addPlayerRow(table, match.getPlayer2());
        addPlayerRow(table, match.getPlayer3());
        addPlayerRow(table, match.getPlayer4());

        doc.add(table);
    }

    private void addHeaderCell(PdfPTable table, String text) {
        PdfPCell cell = new PdfPCell(new Phrase(text, SECTION_FONT));
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(5);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    private void addPlayerRow(PdfPTable table, Player p) {
        int attackTotal = p.getSpikeAttempt() + p.getCutShotAttempt();
        int attackKills = p.getSpikeKill() + p.getCutShotKill();
        double attackPct = attackTotal > 0 ? (double) attackKills / attackTotal * 100 : 0;

        int receiveTotal = p.getGoodReceive() + p.getReceiveForTheOption() + p.getHardToSet() + p.getReceiveError();
        int goodReceive = p.getGoodReceive() + p.getReceiveForTheOption();
        double receivePct = receiveTotal > 0 ? (double) goodReceive / receiveTotal * 100 : 0;

        addDataCell(table, p.getName());
        addDataCell(table, String.format("%.0f%%", attackPct));
        addDataCell(table, String.format("%.0f%%", receivePct));
        addDataCell(table, String.valueOf(p.getMonsterBlock()));
        addDataCell(table, String.valueOf(p.getDig()));
    }

    private void addDataCell(PdfPTable table, String text) {
        PdfPCell cell = new PdfPCell(new Phrase(text, SMALL_FONT));
        cell.setPadding(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
    }

    private void addDivider(Document doc) throws DocumentException {
        Paragraph divider = new Paragraph("------------------------------------------------", SMALL_FONT);
        divider.setSpacingBefore(8);
        divider.setSpacingAfter(8);
        doc.add(divider);
    }
}