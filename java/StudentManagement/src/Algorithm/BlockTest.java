package Algorithm;

public class BlockTest {
    static void main() {
        int[] arr = {1, 3, 2, 5, 4,
                6, 8, 7, 9,
                12, 10, 11,
                15, 13, 14};
        Block block1 = new Block(5, 0, 4);
        Block block2 = new Block(9, 5, 8);
        Block block3 = new Block(12, 9, 11);
        Block block4 = new Block(15, 12, 14);
        Block[] blocks = {block1, block2, block3, block4};
        int index = getIndex(blocks, arr, 12);
        System.out.println(index);
        int index2 = getIndex(blocks, arr, 13);
        System.out.println(index2);

    }

    static class Block {
        private int max;
        private int start;
        private int end;

        Block(int max, int start, int end) {
            this.max = max;
            this.start = start;
            this.end = end;
        }
        public int getMax() {
            return max;
        }
        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }
    }

    public static int getIndex(Block[] blocks, int[] arr, int num) {
        int index = findIndexBlock(blocks, num);
        if (index == -1) {
            return -1;
        }
        int start=blocks[index].getStart();
        int end=blocks[index].getEnd();
        for (int i = start; i <=end ; i++) {
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }

    public static int findIndexBlock(Block[] blocks, int num) {
        for (int i = 0; i < blocks.length; i++) {
            if (num <= blocks[i].getMax()) {
                return i;
            }
        }
        return -1;
    }
}
