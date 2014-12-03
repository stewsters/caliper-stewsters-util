package benchmarks.test;


import com.stewsters.util.mapgen.CellType;

public class ExampleCellType implements CellType {
    public char glyph;
    public boolean blocks;

    public ExampleCellType(char glyph, boolean blocks) {
        this.glyph = glyph;
        this.blocks = blocks;
    }


}
