package com.example.submissionandroid.Response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Response(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("nofollow")
	val nofollow: Boolean? = null,

	@field:SerializedName("noindex")
	val noindex: Boolean? = null,

	@field:SerializedName("nofollow_collections")
	val nofollowCollections: List<String?>? = null,

	@field:SerializedName("previous")
	val previous: @RawValue Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("seo_h1")
	val seoH1: String? = null,

	@field:SerializedName("filters")
	val filters: Filters? = null,

	@field:SerializedName("seo_title")
	val seoTitle: String? = null,

	@field:SerializedName("seo_description")
	val seoDescription: String? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("seo_keywords")
	val seoKeywords: String? = null


) : Parcelable

@Parcelize
data class PlatformsItem(

	@field:SerializedName("requirements_ru")
	val requirementsRu: @RawValue Any? = null,

	@field:SerializedName("requirements_en")
	val requirementsEn: RequirementsEn? = null,

	@field:SerializedName("released_at")
	val releasedAt: String? = null,

	@field:SerializedName("platform")
	val platform: Platform? = null
) : Parcelable

@Parcelize
data class StoresItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("store")
	val store: Store? = null
) : Parcelable

@Parcelize
data class RequirementsEn(

	@field:SerializedName("minimum")
	val minimum: String? = null,

	@field:SerializedName("recommended")
	val recommended: String? = null
) : Parcelable

@Parcelize
data class AddedByStatus(

	@field:SerializedName("owned")
	val owned: Int? = null,

	@field:SerializedName("beaten")
	val beaten: Int? = null,

	@field:SerializedName("dropped")
	val dropped: Int? = null,

	@field:SerializedName("yet")
	val yet: Int? = null,

	@field:SerializedName("playing")
	val playing: Int? = null,

	@field:SerializedName("toplay")
	val toplay: Int? = null
) : Parcelable

@Parcelize
data class GenresItem(

	@field:SerializedName("games_count")
	val gamesCount: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("image_background")
	val imageBackground: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
) : Parcelable

@Parcelize
data class YearsItem(

	@field:SerializedName("filter")
	val filter: String? = null,

	@field:SerializedName("nofollow")
	val nofollow: Boolean? = null,

	@field:SerializedName("decade")
	val decade: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("from")
	val from: Int? = null,

	@field:SerializedName("to")
	val to: Int? = null,

	@field:SerializedName("years")
	val years: List<YearsItem?>? = null,

	@field:SerializedName("year")
	val year: Int? = null
) : Parcelable

@Parcelize
data class ShortScreenshotsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable

@Parcelize
data class TagsItem(

	@field:SerializedName("games_count")
	val gamesCount: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("image_background")
	val imageBackground: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
) : Parcelable

@Parcelize
data class Store(

	@field:SerializedName("games_count")
	val gamesCount: Int? = null,

	@field:SerializedName("domain")
	val domain: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("image_background")
	val imageBackground: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
) : Parcelable

@Parcelize
data class RequirementsRu(

	@field:SerializedName("minimum")
	val minimum: String? = null,

	@field:SerializedName("recommended")
	val recommended: String? = null
) : Parcelable

@Parcelize
data class Filters(

	@field:SerializedName("years")
	val years: List<YearsItem?>? = null
) : Parcelable

@Parcelize
data class RatingsItem(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("percent")
	val percent: Double? = null
) : Parcelable

@Parcelize
data class EsrbRating(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null
) : Parcelable

@Parcelize
data class Platform(

	@field:SerializedName("image")
	val image: @RawValue Any? = null,

	@field:SerializedName("games_count")
	val gamesCount: Int? = null,

	@field:SerializedName("year_end")
	val yearEnd: @RawValue Any? = null,

	@field:SerializedName("year_start")
	val yearStart: @RawValue Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("image_background")
	val imageBackground: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
) : Parcelable

@Parcelize
data class ResultsItem(

	@field:SerializedName("added")
	val added: Int? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("metacritic")
	val metacritic: Int? = null,

	@field:SerializedName("playtime")
	val playtime: Int? = null,

	@field:SerializedName("short_screenshots")
	val shortScreenshots: List<ShortScreenshotsItem?>? = null,

	@field:SerializedName("platforms")
	val platforms: List<PlatformsItem?>? = null,

	@field:SerializedName("user_game")
	val userGame: @RawValue Any? = null,

	@field:SerializedName("rating_top")
	val ratingTop: Int? = null,

	@field:SerializedName("reviews_text_count")
	val reviewsTextCount: Int? = null,

	@field:SerializedName("ratings")
	val ratings: List<RatingsItem?>? = null,

	@field:SerializedName("genres")
	val genres: List<GenresItem?>? = null,

	@field:SerializedName("saturated_color")
	val saturatedColor: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("added_by_status")
	val addedByStatus: AddedByStatus? = null,

	@field:SerializedName("parent_platforms")
	val parentPlatforms: List<ParentPlatformsItem?>? = null,

	@field:SerializedName("ratings_count")
	val ratingsCount: Int? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("released")
	val released: String? = null,

	@field:SerializedName("suggestions_count")
	val suggestionsCount: Int? = null,

	@field:SerializedName("stores")
	val stores: List<StoresItem?>? = null,

	@field:SerializedName("tags")
	val tags: List<TagsItem?>? = null,

	@field:SerializedName("background_image")
	val backgroundImage: String? = null,

	@field:SerializedName("tba")
	val tba: Boolean? = null,

	@field:SerializedName("dominant_color")
	val dominantColor: String? = null,

	@field:SerializedName("esrb_rating")
	val esrbRating: EsrbRating? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null,

	@field:SerializedName("clip")
	val clip: @RawValue Any? = null,

	@field:SerializedName("reviews_count")
	val reviewsCount: Int? = null
) : Parcelable

@Parcelize
data class ParentPlatformsItem(

	@field:SerializedName("platform")
	val platform: Platform? = null
) : Parcelable
