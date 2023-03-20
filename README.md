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