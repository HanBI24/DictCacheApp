# DictCacheApp_Clean_Architecture  

해당 프로젝트는 모듈화가 되어있지 않은 클린 아키텍처 프로젝트를 모듈화한 프로젝트입니다.

## Project Structure

```
 ┌─ common
 │     ├─ Constants.kt
 │     └─ UIEvent.kt
 │
 ├─ core
 │     └─ Resource.kt
 │
 └─ feature_dictionary
       ├─ data
       │     ├─ local
       │     ├─ mapper
       │     ├─ remote
       │     ├─ repository
       │     └─ util
       │
       ├─ domain
       │     ├─ model
       │     ├─ repository
       │     └─ use_case
       │
       └─ presentation
             ├─ di
             ├─ state
             ├─ viewmodel
             ├─ view
             └─ DictApplication.kt
```  
<br>  

모듈화가 되어있지 않은 프로젝트를 보시려면 [non_module](https://github.com/HanBI24/DictCacheApp_Clean_Architecture/tree/non_module) 브런치로 이동하시면 됩니다.  

<br>

## Tistory
해당 Repository의 모듈화 진행 방식은 밑 Tistory 링크를 따라가시면 방식이 나와 있습니다.  
[[Android] Clean Architecture 모듈화 해보기 - 1](https://50billion-dollars.tistory.com/entry/Android-Clean-Architecture-%EB%AA%A8%EB%93%88%ED%99%94-%ED%95%B4%EB%B3%B4%EA%B8%B0-1)  
[[Android] Clean Architecture 모듈화 해보기 - 2](https://50billion-dollars.tistory.com/entry/Android-Clean-Architecture-%EB%AA%A8%EB%93%88%ED%99%94-%ED%95%B4%EB%B3%B4%EA%B8%B0-2)  

<br>

## 참고 자료  
[YouTube](https://youtu.be/Mr8YKDh3li4)  

<br>

## 참고 자료의 수정 내역
1. Mapper 클래스 작성
2. common, core 모듈 생성 및 Resource.kt, UIEvent.kt, Constants.kt 이동 및 생성
3. 해당 프로젝트 기반으로 모듈화 진행
