package restaurant;

import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

public class Tree {
    public static void jTree(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode nodeC = new DefaultMutableTreeNode("寿师傅铁板烧");
        nodeC.add(new DefaultMutableTreeNode("铁板土豆牛肉盖饭"));
        nodeC.add(new DefaultMutableTreeNode("铁板肉末水晶粉丝盖饭"));

        DefaultMutableTreeNode nodeD = new DefaultMutableTreeNode("百味鲜档口");
        nodeD.add(new DefaultMutableTreeNode("百味鲜套餐一"));
        nodeD.add(new DefaultMutableTreeNode("百味鲜套餐二"));
        nodeD.add(new DefaultMutableTreeNode("百味鲜套餐三"));

        DefaultMutableTreeNode nodeE = new DefaultMutableTreeNode("粥铺档口");
        nodeE.add(new DefaultMutableTreeNode("粥铺套餐一"));
        nodeE.add(new DefaultMutableTreeNode("粥铺套餐二"));
        nodeE.add(new DefaultMutableTreeNode("粥铺套餐三"));


        DefaultMutableTreeNode nodeF = new DefaultMutableTreeNode("解忧饼铺档口");
        nodeF.add(new DefaultMutableTreeNode("饼铺套餐一"));
        nodeF.add(new DefaultMutableTreeNode("饼铺套餐二"));
        nodeF.add(new DefaultMutableTreeNode("饼铺热狗蛋炒饭"));

        DefaultMutableTreeNode nodeG = new DefaultMutableTreeNode("忆家味档口");
        nodeG.add(new DefaultMutableTreeNode("西施豆腐"));
        nodeG.add(new DefaultMutableTreeNode("饭团"));
        nodeG.add(new DefaultMutableTreeNode("关东煮"));


        DefaultMutableTreeNode nodeH = new DefaultMutableTreeNode("麻辣香锅档口");
        nodeH.add(new DefaultMutableTreeNode("麻辣香锅套餐"));
        nodeH.add(new DefaultMutableTreeNode("黄焖鸡米饭套餐"));

        DefaultMutableTreeNode nodeI = new DefaultMutableTreeNode("湘味铺档口");
        nodeI.add(new DefaultMutableTreeNode("湘味铺套餐一"));
        nodeI.add(new DefaultMutableTreeNode("湘味铺套餐二"));
        nodeI.add(new DefaultMutableTreeNode("湘味铺套餐三"));


        DefaultMutableTreeNode nodeJ = new DefaultMutableTreeNode("接待餐厅档口");
        nodeJ.add(new DefaultMutableTreeNode("牛柳套饭"));
        nodeJ.add(new DefaultMutableTreeNode("酱鸭肉套饭"));
        nodeJ.add(new DefaultMutableTreeNode("三鲜套饭"));

        DefaultMutableTreeNode nodeK = new DefaultMutableTreeNode("清真餐厅档口");
        nodeK.add(new DefaultMutableTreeNode("清真牛杂盖饭"));
        nodeK.add(new DefaultMutableTreeNode("清真兰州炒饭"));
        nodeK.add(new DefaultMutableTreeNode("清真牛肉炒年糕"));
        nodeK.add(new DefaultMutableTreeNode("清真红烧茄子盖饭"));

        DefaultMutableTreeNode nodeL = new DefaultMutableTreeNode("西餐厅档口");
        nodeL.add(new DefaultMutableTreeNode("西餐厅套餐一"));
        nodeL.add(new DefaultMutableTreeNode("西餐厅套餐二"));
        nodeL.add(new DefaultMutableTreeNode("西餐厅套餐三"));

        root.add(nodeC);
        root.add(nodeD);
        root.add(nodeE);
        root.add(nodeF);
        root.add(nodeG);
        root.add(nodeH);
        root.add(nodeI);
        root.add(nodeJ);
        root.add(nodeK);
        root.add(nodeL);

    }

}