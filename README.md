# cnp4j

![Travis](https://img.shields.io/travis/vrachieru/cnp4j.svg)
[![Coverage Status](https://coveralls.io/repos/github/vrachieru/cnp4j/badge.svg?branch=master)](https://coveralls.io/github/vrachieru/cnp4j?branch=master)

A Java library for generation and validation of the Romanian Personal Identification Number (Cod Numeric Personal, or CNP).


## CNP format

```
|1| |23| |45| |67| |89| |^12| |13|
--- ---- ---- ---- ---- ----- ----
|S| |YY| |MM| |DD| |CC| |NNN| |C|
└─┘ └──┘ └──┘ └──┘ └──┘ └───┘ └─┘
 │   │    │    │    │     │    │
 │   │    │    │    │     │    │
 │   │    │    │    │     │    └─ control digit
 │   │    │    │    │     │
 │   │    │    │    │     └─ order number given to individual
 │   │    │    │    │
 │   │    │    │    └─ county code
 │   │    │    │
 │   │    │    └─ dob day
 │   │    │
 │   │    └─ dob month
 │   │
 │   └─ dob year
 │
 └─ sex (M/F)
    1/2 - romanian citizens born between 01.01.1900 and 31.12.1999
    3/4 - romanian citizens born between 01.01.1800 and 31.12.1899
    5/6 - romanian citizens born between 01.01.2000 and 31.12.2099
    7/8 - residents born between 01.01.1900 and 31.12.1999
      9 - foreign citizens born between 01.01.1900 and 31.12.1999
```

## References

[1] [https://ro.wikipedia.org/wiki/Cod_numeric_personal](https://ro.wikipedia.org/wiki/Cod_numeric_personal)


## License

This project is released under the terms of the [MIT license](http://en.wikipedia.org/wiki/MIT_License).
