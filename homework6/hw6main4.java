public class hw6main4 {
    private int[] column; //ͬ���Ƿ��лʺ�1��ʾ��
    private int[] rup; //�����������Ƿ��лʺ�
    private int[] lup; //�����������Ƿ��лʺ�
    private int[] queen; //���
    private static int num; //�����
    private boolean isShow= false;

    public hw6main4(int n) {
        column = new int[n+1];
        rup = new int[(2*n)+1];
        lup = new int[(2*n)+1];
        for (int i = 1; i <= n; i++)
            column[i] = 0;
        for (int i = 1; i <= (2*n); i++)
            rup[i] = lup[i] = 0;  //��ʼ����ȫ���޻ʺ�
        queen = new int[n+1];
        num=0;
    }

    public void backtrack(int i,int n) {
        if (i > n) {
            showAnswer(n);
        } else {
            for (int j = 1; j <= n; j++) {
                if ((column[j] == 0) && (rup[i+j] == 0) && (lup[i-j+n] == 0)) {
                    //���޻ʺ�
                    queen[i] = j; //�趨Ϊռ��
                    column[j] = rup[i+j] = lup[i-j+n] = 1;
                    backtrack(i+1,n);  //ѭ������
                    column[j] = rup[i+j] = lup[i-j+n] = 0;
                }
            }
        }
    }

    protected void showAnswer(int n) {
        num++;
        if (isShow){
        	System.out.println("\n���" + num);
        	for (int y = 1; y <= n; y++) {
        		for (int x = 1; x <= n; x++) {
        			if(queen[y]==x) {
        				System.out.print("Q"+"\t");
        			} else {
        				System.out.print("."+"\t");
        			}
        		}
        		System.out.println();
        	}
        }
    }

    public static void main(String[] args) {
    	for (int i=4;i<=5;i++){
    		hw6main4 hw6main4 = new hw6main4(i);
    		hw6main4.backtrack(1,i);
    		System.out.println("�ʺ�   "+i+"  �ʺ�������"+ num+"�ֽ������");
//            System.out.println();
    	}

    }
}