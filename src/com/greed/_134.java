package com.greed;

public class _134 {
    /**
     * 如果总油量小于总消耗，无论从哪里出发，都不能绕圈一周
     * 在尝试从某个加油站出发时，需要跟踪当前油箱中的油量，判断是否能到下一个加油站
     * 如果在尝试从 A 加油站出发到加油站 B 的途中油量耗尽，那么 A 到 B 之间的任何加油站
     * 都不能作为出发点，因为从这些加油站出发的油箱里的油量只会更少
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return totalGas >= totalCost ? start : -1;
    }
}
