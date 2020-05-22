package api.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("wrapperType")
    @Expose
    private var wrapperType: String? = null
    @SerializedName("kind")
    @Expose
    private var kind: String? = null
    @SerializedName("trackId")
    @Expose
    private var trackId: Int? = null
    @SerializedName("artistName")
    @Expose
    private var artistName: String? = null
    @SerializedName("trackName")
    @Expose
    private var trackName: String? = null
    @SerializedName("trackCensoredName")
    @Expose
    private var trackCensoredName: String? = null
    @SerializedName("trackViewUrl")
    @Expose
    private var trackViewUrl: String? = null
    @SerializedName("previewUrl")
    @Expose
    private var previewUrl: String? = null
    @SerializedName("artworkUrl30")
    @Expose
    private var artworkUrl30: String? = null
    @SerializedName("artworkUrl60")
    @Expose
    private var artworkUrl60: String? = null
    @SerializedName("artworkUrl100")
    @Expose
    private var artworkUrl100: String? = null
    @SerializedName("collectionPrice")
    @Expose
    private var collectionPrice: Double? = null

    @SerializedName("collectionName")
    @Expose
    private var collectionName: String? = null

    @SerializedName("trackPrice")
    @Expose
    private var trackPrice: Double? = null
    @SerializedName("trackRentalPrice")
    @Expose
    private var trackRentalPrice: Double? = null
    @SerializedName("collectionHdPrice")
    @Expose
    private var collectionHdPrice: Double? = null
    @SerializedName("trackHdPrice")
    @Expose
    private var trackHdPrice: Double? = null
    @SerializedName("trackHdRentalPrice")
    @Expose
    private var trackHdRentalPrice: Double? = null
    @SerializedName("releaseDate")
    @Expose
    private var releaseDate: String? = null
    @SerializedName("collectionExplicitness")
    @Expose
    private var collectionExplicitness: String? = null
    @SerializedName("trackExplicitness")
    @Expose
    private var trackExplicitness: String? = null
    @SerializedName("trackTimeMillis")
    @Expose
    private var trackTimeMillis: Int? = null
    @SerializedName("country")
    @Expose
    private var country: String? = null
    @SerializedName("currency")
    @Expose
    private var currency: String? = null
    @SerializedName("primaryGenreName")
    @Expose
    private var primaryGenreName: String? = null
    @SerializedName("contentAdvisoryRating")
    @Expose
    private var contentAdvisoryRating: String? = null
    @SerializedName("shortDescription")
    @Expose
    private var shortDescription: String? = null
    @SerializedName("longDescription")
    @Expose
    private var longDescription: String? = null

    fun getWrapperType(): String? {
        return wrapperType
    }

    fun setWrapperType(wrapperType: String?) {
        this.wrapperType = wrapperType
    }

    fun getKind(): String? {
        return kind
    }

    fun setKind(kind: String?) {
        this.kind = kind
    }

    fun getTrackId(): Int? {
        return trackId
    }

    fun setTrackId(trackId: Int?) {
        this.trackId = trackId
    }

    fun getArtistName(): String? {
        return artistName
    }

    fun setArtistName(artistName: String?) {
        this.artistName = artistName
    }

    fun getTrackName(): String? {
        return trackName
    }

    fun setTrackName(trackName: String?) {
        this.trackName = trackName
    }

    fun getTrackCensoredName(): String? {
        return trackCensoredName
    }

    fun setTrackCensoredName(trackCensoredName: String?) {
        this.trackCensoredName = trackCensoredName
    }

    fun getTrackViewUrl(): String? {
        return trackViewUrl
    }

    fun setTrackViewUrl(trackViewUrl: String?) {
        this.trackViewUrl = trackViewUrl
    }

    fun getPreviewUrl(): String? {
        return previewUrl
    }

    fun setPreviewUrl(previewUrl: String?) {
        this.previewUrl = previewUrl
    }

    fun getArtworkUrl30(): String? {
        return artworkUrl30
    }

    fun setArtworkUrl30(artworkUrl30: String?) {
        this.artworkUrl30 = artworkUrl30
    }

    fun getArtworkUrl60(): String? {
        return artworkUrl60
    }

    fun setArtworkUrl60(artworkUrl60: String?) {
        this.artworkUrl60 = artworkUrl60
    }

    fun getArtworkUrl100(): String? {
        return artworkUrl100
    }

    fun setArtworkUrl100(artworkUrl100: String?) {
        this.artworkUrl100 = artworkUrl100
    }


    fun getCollectionPrice(): Double? {
        return collectionPrice
    }

    fun setCollectionPrice(collectionPrice: Double?) {
        this.collectionPrice = collectionPrice
    }

    fun getCollectionName(): String? {
        return collectionName
    }

    fun setCollectionName(collectionName: String?) {
        this.collectionName = collectionName
    }

    fun getTrackPrice(): Double? {
        return trackPrice
    }

    fun setTrackPrice(trackPrice: Double?) {
        this.trackPrice = trackPrice
    }

    fun getTrackRentalPrice(): Double? {
        return trackRentalPrice
    }

    fun setTrackRentalPrice(trackRentalPrice: Double?) {
        this.trackRentalPrice = trackRentalPrice
    }

    fun getCollectionHdPrice(): Double? {
        return collectionHdPrice
    }

    fun setCollectionHdPrice(collectionHdPrice: Double?) {
        this.collectionHdPrice = collectionHdPrice
    }

    fun getTrackHdPrice(): Double? {
        return trackHdPrice
    }

    fun setTrackHdPrice(trackHdPrice: Double?) {
        this.trackHdPrice = trackHdPrice
    }

    fun getTrackHdRentalPrice(): Double? {
        return trackHdRentalPrice
    }

    fun setTrackHdRentalPrice(trackHdRentalPrice: Double?) {
        this.trackHdRentalPrice = trackHdRentalPrice
    }

    fun getReleaseDate(): String? {
        return releaseDate
    }

    fun setReleaseDate(releaseDate: String?) {
        this.releaseDate = releaseDate
    }

    fun getCollectionExplicitness(): String? {
        return collectionExplicitness
    }

    fun setCollectionExplicitness(collectionExplicitness: String?) {
        this.collectionExplicitness = collectionExplicitness
    }

    fun getTrackExplicitness(): String? {
        return trackExplicitness
    }

    fun setTrackExplicitness(trackExplicitness: String?) {
        this.trackExplicitness = trackExplicitness
    }

    fun getTrackTimeMillis(): Int? {
        return trackTimeMillis
    }

    fun setTrackTimeMillis(trackTimeMillis: Int?) {
        this.trackTimeMillis = trackTimeMillis
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getCurrency(): String? {
        return currency
    }

    fun setCurrency(currency: String?) {
        this.currency = currency
    }

    fun getPrimaryGenreName(): String? {
        return primaryGenreName
    }

    fun setPrimaryGenreName(primaryGenreName: String?) {
        this.primaryGenreName = primaryGenreName
    }

    fun getContentAdvisoryRating(): String? {
        return contentAdvisoryRating
    }

    fun setContentAdvisoryRating(contentAdvisoryRating: String?) {
        this.contentAdvisoryRating = contentAdvisoryRating
    }

    fun getShortDescription(): String? {
        return shortDescription
    }

    fun setShortDescription(shortDescription: String?) {
        this.shortDescription = shortDescription
    }

    fun getLongDescription(): String? {
        return longDescription
    }

    fun setLongDescription(longDescription: String?) {
        this.longDescription = longDescription
    }


}