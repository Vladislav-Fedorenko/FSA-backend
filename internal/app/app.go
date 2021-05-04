package app

import (
	"context"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/services"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/web/handlers"
	"log"
	"os"
	"os/signal"
	"syscall"
	"time"

	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/core/repositories"
	"github.com/YOUR-USER-OR-ORG-NAME/YOUR-REPO-NAME/internal/server"
)

func Run() {
	repos := repositories.NewRepositories()
	servs := services.NewServices(repos)
	handlrs := handlers.NewHandlers(servs)

	srv := server.NewServer(handlrs.Init())
	go func() {
		if err := srv.Run(); err != nil {
			log.Printf("error occurred while running http server: %s\n", err.Error())
		}
	}()

	log.Print("Server started")

	// Graceful Shutdown
	quit := make(chan os.Signal, 1)
	signal.Notify(quit, syscall.SIGTERM, syscall.SIGINT)

	<-quit

	const timeout = 5 * time.Second

	ctx, shutdown := context.WithTimeout(context.Background(), timeout)
	defer shutdown()

	if err := srv.Stop(ctx); err != nil {
		log.Printf("failed to stop server: %v", err)
	}
}
