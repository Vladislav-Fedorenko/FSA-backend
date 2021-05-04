package handlers

import (
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/services"
	"github.com/gin-gonic/gin"
)

type Handlers struct {
	services      *services.Services
	photosService services.PhotosService
}

type BaseResponse struct {
	Success bool        `json:"success"`
	Data    interface{} `json:"data"`
}

func NewHandlers(services *services.Services) *Handlers {
	return &Handlers{services: services}
}

func (h *Handlers) Init() *gin.Engine {
	router := gin.Default()
	h.initPhotosRoutes(router)
	return router
}
