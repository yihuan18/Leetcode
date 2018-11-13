/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/*
Leetcode Q278 :第一个错误的版本
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。

假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。

你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 */
public class FindFirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return find(1,n);
    }

    private int find(int first,int end){
        if(first == end)
            return first;
        if((first + 1) == end)
            return isBadVersion(first) ? first : end;
        int ret;
        int index = first + (end - first)/2;
        if(isBadVersion(index))
            ret = find(first,index);
        else
            ret = find(index,end);
        return ret;
    }
}
