import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试原则：等价类划分
 * <p>
 * 测试策略：
 * <p>
 * 1.有效分数：
 * 正分数，如 1/2、3/4
 * 负分数，如 -1/2、-3/4
 * 混合正负分数，如 1/2-1/3、-1/2+1/4
 * <p>
 * 2.边界情况：
 * 结果为零的情况，如 1/2-1/2
 * 分数相加后结果为负的情况，如 -1/2-1/3
 * 分数相加后结果为正的情况，如 1/3+1/2
 * <p>
 * 3.结果需要简化的情况：
 * 分数相加后需要简化的情况，如 1/4 + 1/4
 * 大分数相加后的结果需要简化，如 4/2 + 2/2
 */
public class L2022211915_10_Test {
    private final Solution10 solution = new Solution10();

    /**
     * 测试正分数相加。
     */
    @Test
    public void testPositiveFractions() {
        assertEquals("5/6", solution.fractionAddition("1/3+1/2")); // 正分数
        assertEquals("1/1", solution.fractionAddition("1/2+1/2")); // 正分数相同
    }

    /**
     * 测试负分数相加。
     */
    @Test
    public void testNegativeFractions() {
        assertEquals("-5/6", solution.fractionAddition("-1/3-1/2")); // 负分数
        assertEquals("-1/1", solution.fractionAddition("-1/2-1/2")); // 负分数相同
    }

    /**
     * 测试混合分数相加，包括正负数。
     */
    @Test
    public void testMixedFractions() {
        assertEquals("-1/6", solution.fractionAddition("1/3-1/2")); // 混合
        assertEquals("0/1", solution.fractionAddition("1/2-1/2")); // 混合结果为零
        assertEquals("1/3", solution.fractionAddition("1/3+1/3-1/3")); // 多项相加
    }

    // 边界情况测试用例

    /**
     * 确保可以处理结果为零的情况。
     */
    @Test
    public void testZeroResult() {
        assertEquals("0/1", solution.fractionAddition("1/2-1/2")); // 结果为零
        assertEquals("0/1", solution.fractionAddition("-1/3+1/3")); // 结果为零
    }

    /**
     * 测试结果为负的情况。
     */
    @Test
    public void testNegativeResult() {
        assertEquals("-5/6", solution.fractionAddition("-1/3-1/2")); // 负结果
    }

    /**
     * 测试结果为正的情况。
     */
    @Test
    public void testPositiveResult() {
        assertEquals("1/6", solution.fractionAddition("-1/3+1/2")); // 正结果
    }

    // 简化分数测试用例

    /**
     * 确保结果可以被简化。
     */
    @Test
    public void testSimplification() {
        assertEquals("1/2", solution.fractionAddition("1/4+1/4")); // 简化
        assertEquals("1/1", solution.fractionAddition("2/2")); // 简化为1
        assertEquals("2/3", solution.fractionAddition("1/3+1/3")); // 简化
    }
}