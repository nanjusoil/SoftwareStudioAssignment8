# SoftwareStudioAssignment8
Server的部分請到 https://github.com/nanjusoil/SoftwareStudioAssignment8Server
這次的Project很有趣，讓我更加了解Activity的生態，從OnCreate 到Start到 Destroy
我也更加了解Bundle的用法，以前總是覺得為什麼不要全不用JSON就好，現在才知道JSON和bundle各有優劣。
最重要的事Android有一個很好的設計，他先天預設不能在MainThread上面執行Socket這種很容易Block住整個程式運行的thread，
所以要另外開一個Thread。
而如果要銷毀一個Activity只要call destroy()即可，非常方面。
我也更加理解Gradle的用法，他跟我在nodejs寫的npm很像，可以管理套件，並且可以自動Build，我想這也是他Java比C++好用這麼多的原因。
