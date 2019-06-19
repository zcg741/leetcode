//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的原地算法。
//
//

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function (nums, k) {
  if(k > nums.length){
    k = k % nums.length;
  }
  var k0 = 0, kk = nums.length - k - 1, k1 = nums.length - k, k2 = nums.length - 1;
  while (k0 < kk) {
    let flag = nums[k0];
    nums[k0] = nums[kk];
    nums[kk] = flag;
    kk--;
    k0++;
  }

  while (k1 < k2) {
    let flag = nums[k1];
    nums[k1] = nums[k2];
    nums[k2] = flag;
    k2--;
    k1++;
  }
  k0 = 0, k2 = nums.length - 1;
  while (k0 < k2) {
    let flag = nums[k0];
    nums[k0] = nums[k2];
    nums[k2] = flag;
    k2--;
    k0++;
  }
};
var rotate1 = function(nums, k) {
  k = k % nums.length;
  if (k === 0) return;
  let start = 0;
  let next = start;
  let value = nums[start];
  let count = gcd(nums.length, k);
  while (start < count) {
    next =  (next + k) % nums.length;
    let tmp = nums[next];
    nums[next] = value;
    value = tmp;
    if (next === start) {
      start += 1;
      next = start;
      value = nums[start];
    }
  }
};

// 求两个正整数a和b的最大公约数
var gcd = function(a, b) {
  let r;
  while ((r = a % b) !== 0) {
    a = b;
    b = r;
  }
  return b;
};


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate2 = function (nums, k) {
  for (let i = 0; i < k; i++) {
    let first = nums[0];
    nums[0] = nums[nums.length - 1];
    for (let j = 1; j < nums.length; j++) {
      var flag = nums[j];
      nums[j] = first;
      first = flag;
    }
  }
};

var num = [1, 2, 3, 4, 5, 6, 7];
rotate(num, 4)
console.log(num);
num = [-1, -100, 3, 99];
rotate(num, 2)
console.log(num);