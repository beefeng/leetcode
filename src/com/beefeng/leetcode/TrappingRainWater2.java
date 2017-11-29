package com.beefeng.leetcode;

public class TrappingRainWater2 {

  public static int trap(int[][] heightMap) {
    int width = heightMap[0].length;
    int length = heightMap.length;

    int visitMap[][] = new int[length][width];
    int totalVolume = 0;
    for (int level = 0; level < 5; level++) {
      int levelVolume = 0;
      for (int i = 0; i < width; i++) {
        for (int j = 0; j < length; j++) {
          if(i == 0 || i == width -1 || j == 0 || j == length -1) {
            levelVolume = bfs(heightMap, visitMap, level, i, j);
          }
        }
      }
      printVisitStep(level,levelVolume, visitMap);
      totalVolume += levelVolume;
    }
    return 0;
  }

  public static int bfs(int[][] heightMap, int[][] visitMap, int level, int startX, int startY) {
    int visitValue = visitMap[startY][startX];
    int positionHeight = heightMap[startY][startX];
    if (visitValue == 1 || visitValue == -1) {
      return 0;
    } else if (positionHeight == level) {
      visitMap[startY][startX] = -1;

      int w = heightMap[0].length;
      int l = heightMap.length;

      if (startX > 0) {
        bfs(heightMap, visitMap, level, startX - 1, startY);
      }

      if (startY > 0) {
        bfs(heightMap, visitMap, level, startX, startY - 1);
      }

      if (startX < w - 1) {
        bfs(heightMap, visitMap, level, startX + 1, startY);
      }

      if (startY < l - 1) {
        bfs(heightMap, visitMap, level, startX, startY + 1);
      }
    } else if(heightMap[startY][startX] > level) {
      visitMap[startY][startX] = positionHeight;
    }

    return 1;
  }

  public static void printVisitStep(int level, int volume, int[][] visitMap) {
    System.out.println("当前水位：" + level + "容量：" + volume);
    for (int i = 0; i < visitMap.length; i++) {
      for (int j = 0; j < visitMap[0].length; j++) {
        if(j > 0) {
          System.out.print(' ');
        }
        System.out.print(visitMap[i][j]);
      }
      System.out.println('\n');
    }
  }

  public String add(Integer a, String b, StringBuilder sb) {
    return b + a + sb.toString();
  }

  public static void main(String[] args) {
    int[][] heightMap =
        new int[][] { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
    System.out.println(trap(heightMap));

    System.out.println(ReflectUtils.invokeMethod(new TrappingRainWater2(), "add", 1, "haha", new StringBuilder("woshi dayingxiong")));
  }
}
