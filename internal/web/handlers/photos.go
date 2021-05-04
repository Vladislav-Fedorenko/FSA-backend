package handlers

import (
	"fmt"
	"github.com/gin-gonic/gin"
	"net/http"
)

func (h *Handlers) initPhotosRoutes(router *gin.Engine) {
	photos := router.Group("/photos")
	{
		photos.GET("", h.getPhotos)
	}
}

func (h *Handlers) getPhotos(ctx *gin.Context) {
	photos, err := h.services.PhotosService.GetAll(ctx)
	if err != nil {
		ctx.JSON(http.StatusInternalServerError, BaseResponse{false, photos})
	}
	fmt.Print("result = ", photos)
	ctx.JSON(http.StatusOK, BaseResponse{true, photos})
}
