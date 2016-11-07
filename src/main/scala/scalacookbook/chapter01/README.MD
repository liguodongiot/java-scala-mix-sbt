

```
public String[] split(String regex, int limit)
第一个参数表示正则表达式，第二参数最多匹配的个数阀值，0表示尽可能多地匹配字符串。

public String[] split(String regex) {   return split(regex, 0);}
```