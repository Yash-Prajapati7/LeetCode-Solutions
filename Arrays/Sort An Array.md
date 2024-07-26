## Leetcode Question : [Sort an Array](https://leetcode.com/problems/sort-an-array/description/)
- Note : Using other sorting algorithms will give you Time Limit Exceed
## `Shell Sort`
### Java
```java
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = nums[i];
                int j;
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
        return nums;
    }
}
```
### C++
```cpp
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int n = nums.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = nums[i];
                int j;
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
        return nums;
    }
};
```

## `Merge Sort`
### Java
```java
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }
}
```
### C++
```cpp
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        mergeSort(nums, 0, nums.size() - 1);
        return nums;
    }

private:
    void mergeSort(vector<int>& nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    void merge(vector<int>& nums, int low, int mid, int high) {
        vector<int> temp(high - low + 1);
        int left = low, right = mid + 1, k = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[k++] = nums[left++];
        }

        while (right <= high) {
            temp[k++] = nums[right++];
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[low + i] = temp[i];
        }
    }
};
```

## `Heap Sort`
### Java
```java
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // Call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
        return nums;
    }

    // To heapify a subtree rooted with node i which is
    // an index in nums[]. n is size of heap
    private void heapify(int nums[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // Left = 2*i + 1
        int r = 2 * i + 2; // Right = 2*i + 2

        // If left child is larger than root
        if (l < n && nums[l] > nums[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && nums[r] > nums[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(nums, n, largest);
        }
    }
}
```
### C++
```cpp
class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int n = nums.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(nums[0], nums[i]);

            // Call max heapify on the reduced heap
            heapify(nums, i, 0);
        }
        return nums;
    }

private:
    void heapify(vector<int>& nums, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // Left = 2*i + 1
        int r = 2 * i + 2; // Right = 2*i + 2

        // If left child is larger than root
        if (l < n && nums[l] > nums[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && nums[r] > nums[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            swap(nums[i], nums[largest]);

            // Recursively heapify the affected sub-tree
            heapify(nums, n, largest);
        }
    }
};
```
