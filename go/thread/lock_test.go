package thread

import (
	"fmt"
	"sync"
	"testing"
	"time"
)

func TestLock(t *testing.T)  {
	// 创建锁
	var mut sync.Mutex
	counter := 0
	for i:=0; i<5000;i++ {
		go func() {
			// 函数结束的时候释放锁
			defer func() {
				mut.Unlock()
			}()
			// 加锁
			mut.Lock()
			counter++
		}()
	}
	// 等待 1 秒,保证所有的协程都执行完毕
	time.Sleep(1 * time.Second)
	fmt.Println(counter)
}
