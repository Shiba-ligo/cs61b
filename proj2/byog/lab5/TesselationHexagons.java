package byog.lab5;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class TesselationHexagons {
    private static int WIDTH;
    private static int HEIGHT;

    public static void addHexagon(int xstart, int ystart, int sidelength, TETile[][] tiles, TETile kind) {
        int[] boundary = hexagonboundary(xstart, ystart, sidelength);
        fillHexagon(tiles, boundary, sidelength, kind);
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
    private static int[] hexagonboundary(int xstart, int ystart, int sidelength) {
        int[] boundary = new int[4];
        boundary[0] = ystart;
        boundary[1] = ystart + 2 * sidelength - 1;
        boundary[2] = xstart - sidelength + 1;
        boundary[3] = xstart + 2 * sidelength - 2;
        return boundary;
    }
    private static void fillHexagon(TETile[][] tiles, int[] boundary, int sidelength, TETile kind) {
        for (int y = 1; y <= sidelength; y +=  1) {
            for (int x = 1; x <= boundary[3] - boundary[2] + 1; x +=1) {
                if (x > sidelength - y && x < 2 * sidelength + y - 1) {

                    tiles[boundary[2] + x - 1][boundary[0] + y -1] = kind;
                    tiles[boundary[2] + x - 1][boundary[0] + 2 * sidelength - y] = kind;
                }
            }
        }
    }
    private static void add19TeselHexagons(int xstart, int ystart, int sidelength, TETile[][] tiles) {
        int[] position = {0, xstart, 0, ystart};
        for(int i = 1; i < 10; i += 1) {
            if (i == 1 || i == 9) {
                addHexagon(position[1], position[3], sidelength, tiles, Tileset.TREE);
                position = threeTotwo(position[1], position[3], sidelength);
            } else if (position.length == 3) {
                addHexagon(position[0], position[2], sidelength, tiles, Tileset.FLOWER);
                addHexagon(position[1], position[2], sidelength, tiles, Tileset.MOUNTAIN);
                position = twoTothree(position[0], position[2], sidelength);
            } else {
                addHexagon(position[0], position[3], sidelength, tiles, Tileset.GRASS);
                addHexagon(position[1], position[3], sidelength, tiles, Tileset.TREE);
                addHexagon(position[2], position[3], sidelength, tiles, Tileset.FLOWER);
                position = threeTotwo(position[1], position[3], sidelength);
            }
        }
    }
    private static int[] threeTotwo(int xstart, int ystart, int sidelength) {
        int[] position = new int[3];
        position[0] = xstart - 2 * sidelength + 1;
        position[1] = position[0] + 4*sidelength - 2;
        position[2] = ystart - sidelength;
        return position;
    }
    private static int[] twoTothree(int xstart, int ystart, int sidelength) {
        int[] position = new int[4];
        position[0] = xstart - 2 * sidelength + 1;
        position[1] = position[0] + 4*sidelength - 2;
        position[2] = position[1] + 4*sidelength - 2;
        position[3] = ystart - sidelength;
        return position;
    }
    public static void main(String[] args) {
        WIDTH=70;
        HEIGHT=90;
        TERenderer ter = initialization();
        TETile[][] tiles = new TETile[70][90];
        fillworld(tiles);
        add19TeselHexagons(35,80,5,tiles);
        ter.renderFrame(tiles);

    }
}
