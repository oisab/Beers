package com.oisab.beers

//class GetBeersUseCase {
//    val beersRepository = BeersRepository(remoteDataSource, localDataSource)
//    val authRepository = AuthRepository(remoteDataSource, localDataSource)
//    beersRepository.getBeers(authRepository.getToken())
//}
//
//private class AuthRepository(
//    val remoteDataSource: AuthRemoteDataSource,
//    val localDataSource: AuthLocalDataSource
//) {
//    fun getToken() : String {
//        return remoteDataSource.getToken()
//    }
//}
//
//private class BeersRepository(
//    val remoteDataSource: BeersRemoteDataSource,
//    val localDataSource: BeersLocalDataSource
//) {
//    fun getBeers(accessToken: String): List<String> = emptyList()
//}
//
//private class AuthRemoteDataSource {
//    fun getToken(): String = ""
//}