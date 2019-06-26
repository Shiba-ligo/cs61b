package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class SingleHexagon {
    private static int WIDTH;
    private static int HEIGHT;
    public static void addHexagon(int xstart, int ystart, int sidelength, int width, int height) {
        WIDTH=width;
        HEIGHT=height;
        TERenderer ter = initialization();
        TETile[][] tiles = new TETile[WIDTH][HEIGHT];
        fillworld(tiles);
        int[] boundry = hexagonboundry(xstart, ystart, sidelength);
        fillHexagon(tiles, boundry, sidelength);
        ter.renderFrame(tiles);
    }
    private static TERenderer initialization() {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        return ter;
    }
    private static void fillworld(TETile[][] tiles) {
        int height = tiles[0].length;
        int width = tiles.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }
    }
    private static int[] hexagonboundry(int xstart, int ystart, int sidelength) {
        int[] boundary = new int[4];
        boundary[0] = ystart;
        boundary[1] = ystart + 2 * sidelength - 1;
        boundary[2] = xstart - sidelength + 1;
        boundary[3] = xstart + 2 * sidelength - 2;
        return boundary;
    }
    private static void fillHexagon(TETile[][] tiles, int[] boundary, int sidelength) {
        for (int y = 1; y <= sidelength; y +=  1) {
            for (int x = 1; x <= boundary[3] - boundary[2] + 1; x +=1) {
                if (x > sidelength - y && x < 2 * sidelength + y - 1) {

                    tiles[boundary[2] + x - 1][boundary[0] + y -1] = Tileset.FLOWER;
                    tiles[boundary[2] + x - 1][boundary[0] + 2 * sidelength - y] = Tileset.FLOWER;
                }
            }
        }
    }
    public static void main(String[] args) {
        addHexagon(20, 20, 5, 40,40);
    }
}
