package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var scanner *bufio.Scanner

func initScanner() {
	scanner = bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanWords)
}

func readString() string {
	if scanner == nil {
		initScanner()
	}
	if scanner.Scan() {
		return scanner.Text()
	}
	return ""
}

func readInt() int {
	n, _ := strconv.Atoi(readString())
	return n
}

func readInts(n int) []int {
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		arr[i] = readInt()
	}
	return arr
}
func readIntsUnknown() []int {
	var arr []int
	arr = make([]int, 0)
	for {
		num := readInt()
		if num == -1 {
			break
		}
		arr = append(arr, num)
	}
	return arr
}
func findMin(arr []int) int {
	if len(arr) == 0 {

		return 0
	}

	min := arr[0]

	for i := 1; i < len(arr); i++ {
		if arr[i] < min {
			min = arr[i]
		}
	}

	return min
}
func findMax(arr []int) int {
	if len(arr) == 0 {

		return 0
	}

	max := arr[0]

	for i := 1; i < len(arr); i++ {
		if arr[i] > max {
			max = arr[i]
		}
	}

	return max
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
func printArrayWithSpaces(arr []int) {
	// Convert the array to a string with spaces
	arrayString := strings.Trim(strings.Join(strings.Fields(fmt.Sprint(arr)), " "), "[]")

	// Print the formatted string
	fmt.Println(arrayString)
}
func sum(arr []int) int {
	ans := 0
	for i := 0; i < len(arr); i++ {
		ans += arr[i]
	}
	return ans
}
func solve(n int, k int, arr []int) int {
	i := 0
	j := n - 1
	sunkenships := 0
	counter := 0
	for {
		//fmt.Println(i, j, arr, counter, k)
		if k == 0 {
			return sunkenships
		}
		if i == j {
			if k >= arr[i] {
				return sunkenships + 1
			} else {
				return sunkenships
			}
		} else if i > j {
			return sunkenships
		}
		if counter%2 == 0 {
			//decremetn the first
			if k > 0 {
				k--
				arr[i] = arr[i] - 1
				if arr[i] == 0 {
					sunkenships++
					i++
				}
			}
		} else {
			//decreemnt the last
			if k > 0 {
				k--
				arr[j] = arr[j] - 1
				if arr[j] == 0 {
					sunkenships++
					j--
				}
			}
		}
		counter++
	}

	return sunkenships
}
func solve1(n int, k int, arr []int) int {
	i := 0
	j := n - 1
	sunkenships := 0
	counter := 0
	for {
		if k <= 0 {
			return sunkenships
		}
		if i == j {
			if k >= arr[i] {
				return sunkenships + 1
			} else {
				return sunkenships
			}
		} else if i > j {
			return sunkenships
		}
		//fmt.Println(i, j, arr, counter, k)
		if arr[i] > arr[j] {
			if k >= arr[j]*2 {
				arr[i] = arr[i] - arr[j]
				k = k - (arr[j] * 2)
				j--
				sunkenships++
			} else {
				return sunkenships
			}

		} else if arr[i] < arr[j] {
			if k >= arr[i]*2 {
				arr[j] = arr[j] - arr[i]
				k = k - (arr[i] * 2)
				i++
				sunkenships++
			} else {
				return sunkenships
			}
		} else {
			if k >= arr[i]*2 {
				k = k - arr[i]*2
				i++
				j--
				sunkenships += 2
			} else {
				if k >= arr[i] {
					sunkenships += 1
					k = k - arr[i]
				} else {
					return sunkenships
				}
			}
		}
		counter++
	}

	return sunkenships
}

func solve2(n int, k int, arr []int) int {

	for {
		if len(arr) < 1 && k <= 0 {
			break
		}
		mn := min(arr[0], arr[len(arr)-1])
		if k < 2*mn {
			arr[0] -= k/2 + k%2
			arr[len(arr)-1] -= k / 2
		} else {
			arr[0] -= mn
			arr[len(arr)-1] -= mn
		}
		if arr[0] == 0 {
			arr = arr[1:]
		}
		if arr[len(arr)-1] == 0 {
			arr = arr[0 : len(arr)-1]
		}

	}
	ans := n - len(arr)
	if len(arr) > 0 && arr[0] <= k {
		ans += 1
	}
	return ans

}
func main() {
	testCases := readInt()
	ans := make([]int, 0)
	for t := 0; t < testCases; t++ {

		arr := readInts(2)
		n := arr[0]
		k := arr[1]
		arr = readInts(n)
		ans = append(ans, solve1(n, k, arr))

	}
	for i := 0; i < testCases; i++ {
		fmt.Println(ans[i])
	}
}
