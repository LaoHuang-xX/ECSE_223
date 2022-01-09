package ca.mcgill.ecse223.block.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Scrollable;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;
import ca.mcgill.ecse223.block.controller.TOBlock;

public class BlockViewerPanel extends JPanel implements Scrollable {

    private static final long serialVersionUID = 27356344587885L;

    private static final int gridWidth = 6;

    private List<TOBlock> availableBlocks;
    private List<Rectangle2D> drawnBlocks;
    private Block223Page block223page;

    private HashMap<Rectangle2D, TOBlock> rectBlocks;

    public BlockViewerPanel() {
        super();
        block223page = Block223Page.getPage();
        init();
    }

    private void init() {
        // Objects
        drawnBlocks = new ArrayList<>();
        rectBlocks = new HashMap<>();

        // Action listeners
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                for (Rectangle2D rect : drawnBlocks) {
                    if (rect.contains(x, y)) {
                        block223page.showBlockUpdateDelete(rectBlocks.get(rect));
                        break;
                    }
                }
            }
        });
    }

    // Define drawing parameters
    private void doDrawing(Graphics g) {

        try {
            availableBlocks = Block223Controller.getBlocksOfCurrentDesignableGame();
        } catch (InvalidInputException ex) {
            System.out.println("Something went wrong");
            ex.printStackTrace();
        }

        Graphics2D g2d = (Graphics2D) g;

        BasicStroke thinStroke = new BasicStroke(2);
        // BasicStroke thickStroke = new BasicStroke(4);
        g2d.setStroke(thinStroke);

        drawnBlocks.clear();
        rectBlocks.clear();
        
        int x = 0, y = 0;
        
        for (int i = 0; i < availableBlocks.size(); i++) {
            TOBlock tb = availableBlocks.get(i);
            Point tl = new Point(
                    x * (Block223Consts.SIZE * 3 + Block223Consts.COLUMNS_PADDING) + Block223Consts.WALL_PADDING,
                    y * (Block223Consts.SIZE * 3 + Block223Consts.ROW_PADDING) + Block223Consts.WALL_PADDING);
            Rectangle2D block = new Rectangle(tl, new Dimension(Block223Consts.SIZE * 3, Block223Consts.SIZE * 3));
            drawnBlocks.add(block);
            rectBlocks.put(block, tb);

            g2d.setColor(new Color(tb.getRed(), tb.getGreen(), tb.getBlue()));
            g2d.fill(block);
            g2d.setColor(Color.BLACK);
            g2d.draw(block);
            
            // Position next block on lower row if horizontally full
            x++;
            if (x >= gridWidth) {
                x = 0;
                y++;
            }

            this.setPreferredSize(new Dimension(400, y * 63 + 63 + 15));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(400, 400);
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 10;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 10;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }
}