package thread

import (
	"fmt"
	"testing"
)

func TestSelectTest(t *testing.T)  {

	stopSingl := make(chan int)
	go monitor(stopSingl)
	close(stopSingl)

}

func monitor(stopSingl chan int)  {
	for {
		fmt.Println(<-stopSingl)
	}
}