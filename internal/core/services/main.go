package services

import (
	"context"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/models"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/repositories"
)

type PhotosService interface {
	GetAll(ctx context.Context) ([]models.PhotoModel, error)
}

type Services struct {
	PhotosService PhotosService
}

func NewServices(repos *repositories.Repositories) *Services {
	return &Services{
		PhotosService: NewPhotosService(repos.PhotosRepository),
	}
}
