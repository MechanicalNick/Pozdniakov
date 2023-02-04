package com.pozdniakov.movieviewer.data

import com.google.gson.annotations.SerializedName


data class MovieDescription(

    @SerializedName("kinopoiskId") var kinopoiskId: Int? = null,
    @SerializedName("imdbId") var imdbId: String? = null,
    @SerializedName("nameRu") var nameRu: String? = null,
    @SerializedName("nameEn") var nameEn: String? = null,
    @SerializedName("nameOriginal") var nameOriginal: String? = null,
    @SerializedName("posterUrl") var posterUrl: String? = null,
    @SerializedName("posterUrlPreview") var posterUrlPreview: String? = null,
    @SerializedName("coverUrl") var coverUrl: String? = null,
    @SerializedName("logoUrl") var logoUrl: String? = null,
    @SerializedName("reviewsCount") var reviewsCount: Int? = null,
    @SerializedName("ratingGoodReview") var ratingGoodReview: String? = null,
    @SerializedName("ratingGoodReviewVoteCount") var ratingGoodReviewVoteCount: Int? = null,
    @SerializedName("ratingKinopoisk") var ratingKinopoisk: Double? = null,
    @SerializedName("ratingKinopoiskVoteCount") var ratingKinopoiskVoteCount: Int? = null,
    @SerializedName("ratingImdb") var ratingImdb: Double? = null,
    @SerializedName("ratingImdbVoteCount") var ratingImdbVoteCount: Int? = null,
    @SerializedName("ratingFilmCritics") var ratingFilmCritics: Double? = null,
    @SerializedName("ratingFilmCriticsVoteCount") var ratingFilmCriticsVoteCount: Int? = null,
    @SerializedName("ratingAwait") var ratingAwait: Int? = null,
    @SerializedName("ratingAwaitCount") var ratingAwaitCount: Int? = null,
    @SerializedName("ratingRfCritics") var ratingRfCritics: String? = null,
    @SerializedName("ratingRfCriticsVoteCount") var ratingRfCriticsVoteCount: Int? = null,
    @SerializedName("webUrl") var webUrl: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("filmLength") var filmLength: Int? = null,
    @SerializedName("slogan") var slogan: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("shortDescription") var shortDescription: String? = null,
    @SerializedName("editorAnnotation") var editorAnnotation: String? = null,
    @SerializedName("isTicketsAvailable") var isTicketsAvailable: Boolean? = null,
    @SerializedName("productionStatus") var productionStatus: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("ratingMpaa") var ratingMpaa: String? = null,
    @SerializedName("ratingAgeLimits") var ratingAgeLimits: String? = null,
    @SerializedName("countries") var countries: ArrayList<Countries> = arrayListOf(),
    @SerializedName("genres") var genres: ArrayList<Genres> = arrayListOf(),
    @SerializedName("startYear") var startYear: String? = null,
    @SerializedName("endYear") var endYear: String? = null,
    @SerializedName("serial") var serial: Boolean? = null,
    @SerializedName("shortFilm") var shortFilm: Boolean? = null,
    @SerializedName("completed") var completed: Boolean? = null,
    @SerializedName("hasImax") var hasImax: Boolean? = null,
    @SerializedName("has3D") var has3D: Boolean? = null,
    @SerializedName("lastSync") var lastSync: String? = null

)