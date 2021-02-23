package thread

import (
	"fmt"
	"testing"
)

func TestSendChanTest(t *testing.T)  {
	testChan := make(chan int, 10)

	for i:=0; i< 10; i++ {
		i := i
		go func() {
			testChan <- i
		}()
	}

	for num := range testChan {
		fmt.Println(num)
	}

}
